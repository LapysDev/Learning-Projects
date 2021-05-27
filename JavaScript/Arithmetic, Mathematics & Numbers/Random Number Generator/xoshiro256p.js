function xoshiro256(a, b, c, d) {
  function rol64(x, k) { return (x << k) | (x >> (64 - k)) }
  return function() {
    var result = a + d;
    var t = b << 17;

    c ^= a; d ^= b; b ^= c; a ^= d;
    c ^= t; d = rol64(d, 45);

    return result
  }
}
