/* ... ->> `union` because `final` is unavailable in C++98. --- CITE (Lapys) ->
    - http://www.codeproject.com/Tips/617214/UInt-Addition-Subtraction
    - http://www.codeproject.com/Tips/618570/UInt-Multiplication-Squaring
    - https://www.codeproject.com/Tips/784635/UInt-Bit-Operations
    - http://www.codeproject.com/Tips/785014/UInt-Division-Modulus
*/
#include <climits>
#include <cstdio>
#include <stdint.h>

/* ... */
template <typename type> struct can_sizeof { static std::size_t const size = sizeof(type); };

template <bool, typename, typename> union conditional_t;
template <typename true_t, typename false_t> union conditional_t<false, true_t, false_t> { typedef false_t type; };
template <typename true_t, typename false_t> union conditional_t<true, true_t, false_t> { typedef true_t type; };

/* ... */
template <typename> struct uint_extended_t;
template <typename> union uint_next_t;
template <typename> union uint_prev_t;
template <typename uint_t, typename = uint_t> union uint_width_t;

// ...
template<typename, typename> union uint_width_t { typedef uint64_t type; };
template<typename uint_t> union uint_width_t<uint_t, can_sizeof<uint_t> > {
    typedef
        typename conditional_t<
            CHAR_BIT * sizeof(uint_t) <= 255u, uint8_t,
        typename conditional_t<
            CHAR_BIT * sizeof(uint_t) <= 65535u, uint16_t,
        typename conditional_t<
            CHAR_BIT * sizeof(uint_t) <= 4294967295uL, uint32_t,
            uint64_t
        >::type >::type >::type
    type;
};

template <typename uint_t> union uint_prev_t<uint_extended_t<uint_t> > { typedef uint_t type; };
template <> union uint_prev_t<uint8_t> { typedef uint8_t type; };
template <> union uint_prev_t<uint16_t> { typedef uint8_t type; };
template <> union uint_prev_t<uint32_t> { typedef uint16_t type; };
template <> union uint_prev_t<uint64_t> { typedef uint32_t type; };

template <typename uint_t> union uint_next_t { typedef uint_extended_t<uint_t> type; };
template <> union uint_next_t<uint8_t> { typedef uint16_t type; };
template <> union uint_next_t<uint16_t> { typedef uint32_t type; };
template <> union uint_next_t<uint32_t> { typedef uint64_t type; };

template <typename uint_t>
struct uint_extended_t {
    template <typename> struct is_extended_uint { static bool const value = false; };
    template <typename type> struct is_extended_uint<uint_extended_t<type> > { static bool const value = true; };

    public:
        static typename uint_width_t<uint_t>::type const UINT_WIDTH = CHAR_BIT * sizeof(uint_t);
        /* constexpr */ inline static uint_t UINT_MAX_VALUE(void) { static uint_t const maximum = 1u; if (1u == maximum) { typename uint_width_t<uint_t>::type width = UINT_WIDTH; while (--width) maximum <<= 1u; } return maximum; }

        // ...
        uint_t high;
        uint_t low;

        void add(uint_extended_t<uint_t> const number) {
            this -> high += number.high + ((
                ((this -> low & number.low) & 1u) +
                ((this -> low >> 1u) + (number.low >> 1u))
            ) >> (UINT_WIDTH - 1u));
            this -> low += number.low;
        }

        void bitwiseAND(uint_extended_t<uint_t> const number) { this -> high &= number.high; this -> low &= number.low; }
        void bitwiseNOT(void) { this -> high = ~(this -> high); this -> low = ~(this -> low); }
        void bitwiseOR(uint_extended_t<uint_t> const number) { this -> high |= number.high; this -> low |= number.low; }
        void bitwiseXOR(uint_extended_t<uint_t> const number) { this -> high ^= number.high; this -> low ^= number.low; }
        void decrement(void) {
            uint_t const low = this -> low - 1u;

            this -> high -= ((low ^ (this -> low)) & low) >> (UINT_WIDTH - 1u);
            this -> low = low;
        }

        void divide(uint_extended_t<uint_t> number) {
            uint_extended_t<uint_t> quotient = uint_extended_t<uint_t>(0u, 0u);

            if (false == this -> isLesser(number)) {
                typename uint_width_t<uint_t>::type shift;

                typename uint_width_t<uint_t>::type numberLeadingZeroCount = UINT_WIDTH * (0u == number.high);
                typename uint_width_t<uint_t>::type thisLeadingZeroCount = UINT_WIDTH * (0u == this -> high);

                // ...
                for (typename uint_width_t<uint_t>::type iterator = UINT_WIDTH - numberLeadingZeroCount; iterator--; ++numberLeadingZeroCount) { if (0u != number.high >> iterator) break; }
                for (typename uint_width_t<uint_t>::type iterator = UINT_WIDTH - thisLeadingZeroCount; iterator--; ++thisLeadingZeroCount) { if (0u != this -> high >> iterator) break; }

                if (UINT_WIDTH == numberLeadingZeroCount) { numberLeadingZeroCount += UINT_WIDTH * (0u == number.low); for (typename uint_width_t<uint_t>::type iterator = (UINT_WIDTH << 1u) - numberLeadingZeroCount; iterator--; ++numberLeadingZeroCount) { if (0u != number.low >> iterator) break; } }
                if (UINT_WIDTH == thisLeadingZeroCount) { thisLeadingZeroCount += UINT_WIDTH * (0u == this -> low); for (typename uint_width_t<uint_t>::type iterator = (UINT_WIDTH << 1u) - thisLeadingZeroCount; iterator--; ++thisLeadingZeroCount) { if (0u != this -> low >> iterator) break; } }

                // ...
                shift = numberLeadingZeroCount - thisLeadingZeroCount;
                number.shiftLeft(shift);

                do {
                    quotient.shiftLeft(1u);
                    if (false == this -> isLesser(number)) {
                        this -> subtract(number);
                        quotient.low |= 1u;
                    }

                    number.shiftRight(1u);
                } while (shift--);
            }

            this -> high = quotient.high;
            this -> low = quotient.low;
        }

        void increment(void) {
            uint_t const low = this -> low + 1u;

            this -> high += ((this -> low ^ low) & this -> low) >> (UINT_WIDTH - 1u);
            this -> low = low;
        }

        bool isEqual(uint_extended_t<uint_t> const number) const { return this -> high == number.high && this -> low == number.low; }
        bool isGreater(uint_extended_t<uint_t> const number) const { return this -> high > number.high || (this -> high == number.high && this -> low > number.low); }
        bool isLesser(uint_extended_t<uint_t> const number) const { return this -> high < number.high || (this -> high == number.high && this -> low < number.low); }
        bool isZero(void) const { return 0u == this -> high && 0u == this -> low; }
        void modulo(uint_extended_t<uint_t> const number) { this -> remainder(number); }
        void multiply(uint_extended_t<uint_t> const number) {
            typename uint_width_t<typename uint_prev_t<uint_t>::type>::type const PREV_WIDTH = UINT_WIDTH >> 1u;
            typename uint_prev_t<uint_t>::type PREV_MAX_VALUE = 1u;
                for (typename uint_width_t<typename uint_prev_t<uint_t>::type>::type width = PREV_WIDTH; --width; ) PREV_MAX_VALUE <<= 1u;
                PREV_MAX_VALUE += PREV_MAX_VALUE--;

            uint_t const lowMultiplication = (number.low & PREV_MAX_VALUE) * (this -> low & PREV_MAX_VALUE);
            uint_t numberLow = number.low;
            uint_t thisLow = this -> low;
            uint_t thisLowControl = lowMultiplication;
            uint_t thisHighControl = lowMultiplication >> PREV_WIDTH;

            // ...
            thisLow >>= PREV_WIDTH; {
                thisLowControl = thisHighControl + (thisLow * (number.low & PREV_MAX_VALUE));
                thisHighControl = thisLowControl & PREV_MAX_VALUE;
            }

            numberLow >>= PREV_WIDTH; {
                thisLowControl = thisHighControl + (numberLow * (this -> low & PREV_MAX_VALUE));
                thisHighControl = thisLowControl >> PREV_WIDTH;
            }

            // ...
            this -> low = (thisLowControl << PREV_WIDTH) + (lowMultiplication & PREV_MAX_VALUE);
            this -> high = thisHighControl + (
                (numberLow * thisLow) +
                ((this -> high * number.low) + (this -> low * number.high)) +
                ((
                    (lowMultiplication >> PREV_WIDTH) +
                    (thisLow * (number.low & PREV_MAX_VALUE))
                ) >> PREV_WIDTH)
            );
        }

        void remainder(uint_extended_t<uint_t> const number) {
            uint_extended_t<uint_t> divisor = uint_extended_t<uint_t>(number.high, number.low);

            while (0u == (divisor.high >> (UINT_WIDTH - 1u)) && false == this -> isLesser(divisor)) divisor.shiftLeft(1u);
            while (false == this -> isLesser(number)) {
                while (this -> isLesser(divisor) && false == divisor.isEqual(number)) divisor.shiftRight(1u);
                this -> subtract(divisor);
            }
        }

        void shiftLeft(typename uint_width_t<typename uint_next_t<uint_t>::type>::type count) {
            while (count--) {
                this -> high = (this -> high << 1u) | (0u != this -> low >> (UINT_WIDTH - 1u));
                this -> low <<= 1u;
            }
        }

        void shiftRight(typename uint_width_t<typename uint_next_t<uint_t>::type>::type count) {
            while (count--) {
                this -> low = (this -> low >> 1u) | ((this -> high & 1u) << (UINT_WIDTH - 1u));
                this -> high >>= 1u;
            }
        }

        void subtract(uint_extended_t<uint_t> const number) {
            this -> low -= number.low;
            this -> high -= number.high + ((
                ((this -> low & number.low) & 1u) +
                ((this -> low >> 1u) + (number.low >> 1u))
            ) >> (UINT_WIDTH - 1u));
        }

    public:
        uint_extended_t(uint_t const high, uint_t const low) : high(high), low(low) {}
        uint_extended_t(typename conditional_t<is_extended_uint<typename uint_next_t<uint_t>::type>::value, uint_t, typename uint_next_t<uint_t>::type>::type const number = 0u) {
            if (sizeof(number) > sizeof(uint_t)) {
                typename conditional_t<is_extended_uint<typename uint_next_t<uint_t>::type>::value, uint_t, typename uint_next_t<uint_t>::type>::type value = number;

                for (typename uint_width_t<uint_t>::type width = UINT_WIDTH; width; --width) value >>= 1u;
                this -> high = value;

                for (typename uint_width_t<uint_t>::type width = UINT_WIDTH; width; --width) value <<= 1u;
                this -> low = number & ~value;
            }

            else {
                this -> high = 0u;
                this -> low = number;
            }
        }

        // ...
        uint_extended_t<uint_t> operator +(void) const { return uint_extended_t<uint_t>(this -> high, this -> low); }
        uint_extended_t<uint_t> operator -(void) const { return uint_extended_t<uint_t>(UINT_MAX_VALUE(), UINT_MAX_VALUE()).subtract(*this); }
        friend uint_extended_t<uint_t> operator +(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.add(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator -(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.subtract(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator *(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.multiply(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator /(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.divide(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator %(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.modulo(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator &(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.bitwiseAND(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator |(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.bitwiseOR(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator ^(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.bitwiseXOR(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator <<(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.shiftLeft(numberB); return numberA; }
        friend uint_extended_t<uint_t> operator >>(uint_extended_t<uint_t> numberA, uint_extended_t<uint_t> const numberB) { numberA.shiftRight(numberB); return numberA; }
        uint_extended_t<uint_t> operator ~(void) const { uint_extended_t<uint_t> complement = uint_extended_t<uint_t>(this -> high, this -> low); complement.bitwiseNOT(); return complement; }
        bool operator !(void) const { return this -> isZero(); }
        friend bool operator <(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return numberA.isLesser(numberB); }
        friend bool operator >(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return numberA.isGreater(numberB); }
        friend bool operator ==(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return numberA.isEqual(numberB); }
        friend bool operator !=(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return false == operator ==(numberA, numberB); }
        friend bool operator <=(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return operator ==(numberA, numberB) || operator <(numberA, numberB); }
        friend bool operator >=(uint_extended_t<uint_t> const numberA, uint_extended_t<uint_t> const numberB) { return operator ==(numberA, numberB) || operator >(numberA, numberB); }

        uint_extended_t& operator +=(uint_extended_t<uint_t> const number) { this -> add(number); return *this; }
        uint_extended_t& operator -=(uint_extended_t<uint_t> const number) { this -> subtract(number); return *this; }
        uint_extended_t& operator *=(uint_extended_t<uint_t> const number) { this -> multiply(number); return *this; }
        uint_extended_t& operator /=(uint_extended_t<uint_t> const number) { this -> divide(number); return *this; }
        uint_extended_t& operator %=(uint_extended_t<uint_t> const number) { this -> modulo(number); return *this; }
        uint_extended_t& operator &=(uint_extended_t<uint_t> const number) { this -> bitwiseAND(number); return *this; }
        uint_extended_t& operator |=(uint_extended_t<uint_t> const number) { this -> bitwiseOR(number); return *this; }
        uint_extended_t& operator ^=(uint_extended_t<uint_t> const number) { this -> bitwiseXOR(number); return *this; }
        uint_extended_t& operator <<=(typename uint_width_t<typename uint_next_t<uint_t>::type>::type const count) { this -> shiftLeft(count); return *this; }
        uint_extended_t& operator >>=(typename uint_width_t<typename uint_next_t<uint_t>::type>::type const count) { this -> shiftRight(count); return *this; }
        uint_extended_t& operator ++(void) { this -> increment(); return *this; }
        uint_extended_t operator ++(int const) { uint_extended_t<uint_t> const increment = uint_extended_t<uint_t>(this -> high, this -> low); this -> increment(); return increment; }
        uint_extended_t& operator --(void) { this -> decrement(); return *this; }
        uint_extended_t operator --(int const) { uint_extended_t<uint_t> const decrement = uint_extended_t<uint_t>(this -> high, this -> low); this -> decrement(); return decrement; }

        template <typename type> operator type(void) const {
            type number = type(0u);

            if (sizeof(type) <= sizeof(uint_t)) {
                number = this -> high;
                for (typename uint_width_t<uint_t>::type width = UINT_WIDTH; width; --width) number <<= 1u;
            }

            return this -> low | number;
        }
};

// ...
template <typename uint_t>
char const* stringify(uint_t number) {
    static char string[1025] = {0};

    char *iterator = string + 1024;
    uint_t const radix = uint_t(0u, 10u), zero = uint_t(0u);

    // ...
    for (*--iterator = '0'; number != zero; number /= radix)
    *(iterator--) = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"[static_cast<unsigned char>(number % radix)];

    return static_cast<char const*>(iterator + (1024 != iterator - string));
}

/* Main */
int main(void) {
    // 255
    // uint8_t const UINT8_MAXIMUM = -1;
    // std::printf("[1 << 8]: %s" "\r\n", stringify(UINT8_MAXIMUM));

    // 65535
    uint_extended_t<uint8_t> const UINT16_MAXIMUM = -1;
    std::printf("[1 << 16]: %s" "\r\n", stringify(UINT16_MAXIMUM));

    // 4294967295
    uint_extended_t<uint16_t> const UINT32_MAXIMUM = -1;
    std::printf("[1 << 32]: %s" "\r\n", stringify(UINT32_MAXIMUM));

    // 18446744073709551615
    uint_extended_t<uint32_t> const UINT64_MAXIMUM = -1;
    std::printf("[1 << 64]: %s" "\r\n", stringify(UINT64_MAXIMUM));

    // 340282366920938463463374607431768211455
    uint_extended_t<uint64_t> const UINT128_MAXIMUM = uint_extended_t<uint64_t>(-1, -1);
    std::printf("[1 << 128]: %s" "\r\n", stringify(UINT128_MAXIMUM));

    // 115792089237316195423570985008687907853269984665640564039457584007913129639935
    uint_extended_t<uint_extended_t<uint64_t> > const UINT256_MAXIMUM = uint_extended_t<uint_extended_t<uint64_t> >(
        uint_extended_t<uint64_t>(-1, -1),
        uint_extended_t<uint64_t>(-1, -1)
    );
    std::printf("[1 << 256]: %s" "\r\n", stringify(UINT256_MAXIMUM));

    // 13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084095
    uint_extended_t<uint_extended_t<uint_extended_t<uint64_t> > > const UINT512_MAXIMUM = uint_extended_t<uint_extended_t<uint_extended_t<uint64_t> > >(
        uint_extended_t<uint_extended_t<uint64_t> >(uint_extended_t<uint64_t>(-1, -1), uint_extended_t<uint64_t>(-1, -1)),
        uint_extended_t<uint_extended_t<uint64_t> >(uint_extended_t<uint64_t>(-1, -1), uint_extended_t<uint64_t>(-1, -1))
    );
    std::printf("[1 << 512]: %s" "\r\n", stringify(UINT512_MAXIMUM));

    // ...
    return /* --> EXIT_SUCCESS */ 0x0;
}