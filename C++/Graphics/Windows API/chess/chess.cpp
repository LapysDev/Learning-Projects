/* ... --> advapi32.lib, gdi32.lib, kernel32.lib, shell32.lib, user32.lib
    --- WARN ---
    #Lapys:
*/
/* Definition > ... */
#undef UNICODE

/* Import */
// : [C Standard Library]
#include <stdint.h> // Standard Integers

// : [C++ Standard Library]
#include <csignal> // C Signal
#include <cstdio> // C Standard Input/ Output
#include <cstdlib> // C Standard Library

// : [Windows API]
#include <windef.h> // Windows Definitions
#include <winbase.h> // Windows Base
#include <winerror.h> // Windows Errors
#include <wingdi.h> // Windows GDI
#include <winnt.h> // Windows New Technologies
#include <winuser.h> // Windows User
#   include <basetsd.h> // Base Types & Definitions
#   include <errhandlingapi.h> // Error Handling API
#   include <libloaderapi.h> // Library Loader API
#   include <memoryapi.h> // Memory API
#   include <shellapi.h> // Shell API

/* Phase */
// : Singular `INITIATE` called by entry point;
// : Definitions for `RESET`, `TERMINATE`, `UPDATE` but more are allowed & callable by programmer
static void INITIATE (...);
       void RESET    (   );
       void TERMINATE(   );
       void UPDATE   (   );

void TERMINATE(char const[]);
LRESULT CALLBACK UPDATE(HWND const, UINT const, WPARAM const, LPARAM const);

/* Class */
// : Piece
typedef struct Piece /* final */ {
    enum Color /* : bool */ { BLACK = 0u, WHITE = 1u };
    enum Type /* : unsigned char */ { BISHOP = 1u, KING = 2u, KNIGHT = 3u, PAWN = 4u, QUEEN = 5u, ROOK = 6u };

    private: unsigned char *const data;
    public:
        Piece(unsigned char* const data) : data(data) {}

        Color getColor(void) const;
        unsigned char getColumn(void) const;
        unsigned char* getData(void) const;
        signed char getIndex(void) const;
        unsigned char getPosition(void) const;
        unsigned char getRow(void) const;
        Type getType(void) const;

        void setColumn(unsigned char const);
        void setPosition(unsigned char const, unsigned char const);
        void setRow(unsigned char const);
} Bishop, King, Knight, Pawn, Queen, Rook;

/* Namespace */
/* : Game
    --- WARNING (Lapys) -> Requires a byte to be at least 8 bits
    --- UPDATE (Lapys) -> Could feasibly algorithmically compress the game to a single integer state i.e.: 35 to the 80th possible moves
    --- NOTE (Lapys) -> Memory model (with an unimplemented custom 32-turn draw)
       flag               index            flag                             bit
      [CASTLE STATE (4) | EN-PASSANT (4)] [CAPTURED QUEEN & OFFICERS (14) | TURN (1)]
      [0000             | 0000          ] [00000000 000000                | - 0     ]

       position                pos.             position                 pos.              position                pos.             position                 pos.
      [BLACK KING ROOK   (6) | BLACK KING (2) | BLACK QUEEN ROOK   (6) | BLACK QUEEN (2) | WHITE KING ROOK   (6) | WHITE KING (2) | WHITE QUEEN ROOK   (6) | WHITE QUEEN (2)]
      [000000                | 00             | 000000                 | 00              | 000000                | 00             | 000000                 | 00             ]

       position                pos.             position                 pos.              position                pos.             position                 pos.
      [BLACK KING KNIGHT (6) | BLACK KING (2) | BLACK QUEEN KNIGHT (6) | BLACK QUEEN (2) | WHITE KING KNIGHT (6) | WHITE KING (2) | WHITE QUEEN KNIGHT (6) | WHITE QUEEN (2)]
      [000000                | 00             | 000000                 | 00              | 000000                | 00             | 000000                 | 00             ]

       position                pos.             position                 pos.              position                pos.             position                 pos.
      [BLACK KING BISHOP (5) | BLACK KING (2) | BLACK QUEEN BISHOP (5) | BLACK QUEEN (2) | WHITE KING BISHOP (5) | WHITE KING (2) | WHITE QUEEN BISHOP (5) | WHITE QUEEN (2)]
      [00000 -               | 00             | 00000 -                | 00              | 00000 -               | 00             | 00000 -                | 00             ]

       pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type
      [BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8) | BLACK PAWN (8)]
      [000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00     ]

       flag                      flag
      [CAPTURED BLACK PAWN (8)] [PROMOTED BLACK PAWN (8)]
      [00000000               ] [00000000               ]

       pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type      pos.   type
      [WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8) | WHITE PAWN (8)]
      [000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00      | 000000 00     ]

       flag                      flag
      [CAPTURED WHITE PAWN (8)] [PROMOTED WHITE PAWN (8)]
      [00000000               ] [00000000               ]
*/
namespace Game {
    static unsigned char MEMORY[/* 275 ÷ CHAR_BIT */ 35] = {0}; // ->> Encoded in terms of recency.

    enum PiecesEnumerationControl { CONTINUE_ENUMERATING_PIECES, STOP_ENUMERATING_PIECES };
    enum MemorySegment {
        BISHOPS, KNIGHTS, KINGS, PAWNS, QUEENS, ROOKS,
        CAPTURED_OFFICERS, CAPTURED_PAWNS, CASTLE, EN_PASSANT, PROMOTED_PAWNS, TURN
    };

    // ...
    static void capturePiece(Piece, Piece const);
    static void castleRook(Rook const);
    static PiecesEnumerationControl enumeratePieces(PiecesEnumerationControl (*const)(Piece));
    static bool hasPiece(unsigned char const, unsigned char const);
    static void movePiece(Piece, unsigned char const, unsigned char const);
    static void promotePawn(Pawn const, Piece::Type const);
    static void removePiece(Piece const);

    // ...
    static unsigned char getColumnCount(void);
    static Pawn getEnPassantPawn(void);
    static unsigned char* getMemorySegment(MemorySegment const);
    static Piece::Type getPawnPromotion(Pawn const);
    static Piece getPiece(Piece::Color const, Piece::Type const, unsigned char const = 0u);
    static unsigned char getPieceCount(Piece::Type const);
    static unsigned char getRowCount(void);
    static unsigned char getTileCount(void);
    static Piece::Color getTurn(void);

    static bool isPawnPromoted(Pawn const);
    static bool isPieceCaptured(Piece const);
    static bool isRookCastled(Rook const);

    static void setEnPassantPawn(Pawn const);
    static void setPawnPromotion(Pawn, Piece::Type const);
    static void setTurn(Piece::Color const);
}

// : Program ->> Pre-defined for use by the programmer; Setup (partially) in entry point
namespace Program {
    namespace Lock {
        static HANDLE FILE = NULL;
        static HANDLE MUTEX = NULL;

        static char const *FILE_NAME = NULL;
        static char const *MUTEX_NAME = NULL;
    }

    static LPSTR ARGUMENTS = NULL;
    static int EXIT_CODE = EXIT_SUCCESS;
    static CHAR FILE_NAME[MAX_PATH] = {0};
    static HINSTANCE HANDLE = NULL;
    static HINSTANCE PREVIOUS_HANDLE = NULL;
    static MSG THREAD_MESSAGE = MSG();

    // ...
    static void exit(void);
    static void exit(int const);
    static void raise(int const);

    static void (*onabort)(void) = NULL;
    static void (*onexit)(void) = NULL;
    static void (*oninterrupt)(void) = NULL;
    static void (*oninvalidfault)(void) = NULL;
    static void (*onmathfault)(void) = NULL;
    static void (*onsegfault)(void) = NULL;
    static void (*onterminate)(void) = NULL;
}

// : Window ->> Pre-defined for use by the programmer; Setup (partially) in entry point
namespace Window {
    static int APPEARANCE = SW_SHOW;
    static HBRUSH BACKGROUND = NULL;
    static LPCSTR const CLASS_NAME = "window";
    static UINT const CLASS_STYLE = CS_GLOBALCLASS | CS_OWNDC;
    static HCURSOR CURSOR = NULL;
    static HICON FAVICON = NULL;
    static HICON ICON = NULL;
    static int LEFT = -1, HEIGHT = -1, TOP = -1, WIDTH = -1;
    static HWND HANDLE = NULL;
    static LRESULT CALLBACK (*PROCEDURE)(HWND const, UINT const, WPARAM const, LPARAM const) = ::DefWindowProc;
    static DWORD STYLE = WS_OVERLAPPEDWINDOW;
    static DWORD STYLE_EXTENSION = 0x0u;
    static LPCSTR TITLE = "";

    // ...
    static HBITMAP DEVICE_CONTEXT_BITMAP_HANDLE = NULL;
    static HDC DEVICE_CONTEXT_HANDLE = NULL;

    static BITMAP MEMORY_DEVICE_CONTEXT_BITMAP = BITMAP();
    static VOID *MEMORY_DEVICE_CONTEXT_BITMAP_BITS = NULL;
    static HBITMAP MEMORY_DEVICE_CONTEXT_BITMAP_HANDLE = NULL;
    static HDC MEMORY_DEVICE_CONTEXT_HANDLE = NULL;
}

/* Functions */
// : Game ...
void Game::capturePiece(Piece capturer, Piece const captured) {
    unsigned char const column = captured.getColumn();
    unsigned char const row = captured.getRow();

    Game::removePiece(captured);
    Game::movePiece(capturer, column, row);
}

void Game::castleRook(Rook const rook) {
    *Game::getMemorySegment(Game::CASTLE) &= 0xFu | ((
        (*Game::getMemorySegment(Game::CASTLE) >> 4u) |
        (1u << (rook.getIndex() + ((Piece::WHITE == rook.getColor()) << 1u)))
    ) << 4u);
}

Game::PiecesEnumerationControl Game::enumeratePieces(PiecesEnumerationControl (*const handler)(Piece)) {
    for (Piece::Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Piece::Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = 0u; iterator != Game::getPieceCount(type); ++iterator) {
        if (Game::STOP_ENUMERATING_PIECES == handler(Game::getPiece(Piece::BLACK, type, iterator)))
        return Game::STOP_ENUMERATING_PIECES;
    }

    for (Piece::Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Piece::Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = 0u; iterator != Game::getPieceCount(type); ++iterator) {
        if (Game::STOP_ENUMERATING_PIECES == handler(Game::getPiece(Piece::WHITE, type, iterator)))
        return Game::STOP_ENUMERATING_PIECES;
    }

    return Game::CONTINUE_ENUMERATING_PIECES;
}

unsigned char Game::getColumnCount(void) {
    return 8u;
}

Pawn Game::getEnPassantPawn(void) {
    unsigned char const count = Game::getPieceCount(Piece::PAWN);
    unsigned char const index = *Game::getMemorySegment(Game::EN_PASSANT) & 0xF;

    return Game::getPiece(count > index ? Piece::BLACK : Piece::WHITE, Piece::PAWN, index % count);
}

unsigned char* Game::getMemorySegment(MemorySegment const segment) {
    switch (segment) {
        case Game::BISHOPS: return Game::MEMORY + 20;
        case Game::KNIGHTS: return Game::MEMORY + 24;
        case Game::KINGS: return Game::MEMORY - 1;
        case Game::PAWNS: return Game::MEMORY + 0;
        case Game::QUEENS: return Game::MEMORY - 3;
        case Game::ROOKS: return Game::MEMORY + 28;

        case Game::CAPTURED_PAWNS: return Game::MEMORY + 16;
        case Game::CAPTURED_OFFICERS: return Game::MEMORY + 33;
        case Game::CASTLE: return Game::MEMORY + 32;
        case Game::EN_PASSANT: return Game::MEMORY + 32;
        case Game::PROMOTED_PAWNS: return Game::MEMORY + 18;
        case Game::TURN: return Game::MEMORY + 34;
    }

    return NULL;
}

Piece::Type Game::getPawnPromotion(Pawn const pawn) {
    switch (*pawn.getData() >> 6u) {
        case 0x0u: return Piece::BISHOP;
        case 0x1u: return Piece::KNIGHT;
        case 0x2u: return Piece::QUEEN;
        case 0x3u: return Piece::ROOK;
    }

    return Piece::PAWN;
}

Piece Game::getPiece(Piece::Color const color, Piece::Type const type, unsigned char const index) {
    switch (type) {
        case Piece::BISHOP: return Piece(Game::getMemorySegment(Game::BISHOPS) + index + (Game::getPieceCount(Piece::BISHOP) * (Piece::WHITE == color)));
        case Piece::KING: return Piece(Game::getMemorySegment(Game::KINGS) + index - (0L + (1L << (Piece::WHITE == color))));
        case Piece::KNIGHT: return Piece(Game::getMemorySegment(Game::KNIGHTS) + index + (Game::getPieceCount(Piece::KNIGHT) * (Piece::WHITE == color)));
        case Piece::PAWN: return Piece(Game::getMemorySegment(Game::PAWNS) + index + (Game::getPieceCount(Piece::PAWN) * (Piece::WHITE == color)));
        case Piece::QUEEN: return Piece(Game::getMemorySegment(Game::QUEENS) + index - (2L + (1L << (Piece::WHITE == color))));
        case Piece::ROOK: return Piece(Game::getMemorySegment(Game::ROOKS) + index + (Game::getPieceCount(Piece::ROOK) * (Piece::WHITE == color)));
    }

    return Piece(NULL);
}

unsigned char Game::getPieceCount(Piece::Type const type) {
    switch (type) {
        case Piece::BISHOP: case Piece::KNIGHT: case Piece::ROOK: return 2u;
        case Piece::KING: case Piece::QUEEN: return 1u;
        case Piece::PAWN: return 8u;
    }

    return 0u;
}

unsigned char Game::getRowCount(void) {
    return 8u;
}

unsigned char Game::getTileCount(void) {
    return Game::getColumnCount() * Game::getRowCount();
}

Piece::Color Game::getTurn(void) {
    return *Game::getMemorySegment(Game::TURN) & 1u ? Piece::WHITE : Piece::BLACK;
}

bool Game::hasPiece(unsigned char const column, unsigned char const row) {
    for (Piece::Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Piece::Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = Game::getPieceCount(type); iterator--; ) {
        Piece const piece = Game::getPiece(Piece::WHITE, type, iterator);
        if (column == piece.getColumn() && row == piece.getRow()) return true;
    }

    return false;
}

bool Game::isPawnPromoted(Pawn const pawn) {
    return (Game::getMemorySegment(Game::PROMOTED_PAWNS)[Piece::WHITE == pawn.getColor()] >> pawn.getIndex()) & 1u;
}

bool Game::isPieceCaptured(Piece const piece) {
    switch (piece.getType()) {
        case Piece::KING: return false;
        case Piece::PAWN: return (Game::getMemorySegment(Game::CAPTURED_PAWNS)[Piece::WHITE == piece.getColor()] >> piece.getIndex()) & 1u;

        case Piece::BISHOP: return ((Game::getMemorySegment(Game::CAPTURED_OFFICERS)[0] >> 4u) >> (piece.getIndex() + (Game::getPieceCount(Piece::BISHOP) * (Piece::WHITE == piece.getColor())))) & 1u;
        case Piece::KNIGHT: return ((Game::getMemorySegment(Game::CAPTURED_OFFICERS)[0] >> 0u) >> (piece.getIndex() + (Game::getPieceCount(Piece::KNIGHT) * (Piece::WHITE == piece.getColor())))) & 1u;
        case Piece::QUEEN : return ((Game::getMemorySegment(Game::CAPTURED_OFFICERS)[1] >> 2u) >> (piece.getIndex() + (Game::getPieceCount(Piece::QUEEN ) * (Piece::WHITE == piece.getColor())))) & 1u;
        case Piece::ROOK  : return ((Game::getMemorySegment(Game::CAPTURED_OFFICERS)[1] >> 4u) >> (piece.getIndex() + (Game::getPieceCount(Piece::ROOK  ) * (Piece::WHITE == piece.getColor())))) & 1u;
    }

    return false;
}

bool Game::isRookCastled(Rook const rook) {
    return ((*Game::getMemorySegment(Game::CASTLE) >> 4u) >> (rook.getIndex() + (Game::getPieceCount(Piece::ROOK) * (Piece::WHITE == rook.getColor())))) & 1u;
}

void Game::movePiece(Piece piece, unsigned char const column, unsigned char const row) {
    piece.setPosition(column, row);
}

void Game::promotePawn(Pawn const pawn, Piece::Type const type) {
    Game::getMemorySegment(Game::PROMOTED_PAWNS)[Piece::WHITE == pawn.getColor()] |= 1u << pawn.getIndex();
    Game::setPawnPromotion(pawn, type);
}

void Game::removePiece(Piece const piece) {
    switch (piece.getType()) {
        case Piece::KING: break;
        case Piece::PAWN: Game::getMemorySegment(Game::CAPTURED_PAWNS)[Piece::WHITE == piece.getColor()] |= 1u << piece.getIndex(); break;

        case Piece::BISHOP: Game::getMemorySegment(Game::CAPTURED_OFFICERS)[0] |= 1u << ((piece.getIndex() + (Game::getPieceCount(Piece::BISHOP) * (Piece::WHITE == piece.getColor()))) << 4u); break;
        case Piece::KNIGHT: Game::getMemorySegment(Game::CAPTURED_OFFICERS)[0] |= 1u << ((piece.getIndex() + (Game::getPieceCount(Piece::KNIGHT) * (Piece::WHITE == piece.getColor()))) << 0u); break;
        case Piece::QUEEN : Game::getMemorySegment(Game::CAPTURED_OFFICERS)[1] |= 1u << ((piece.getIndex() + (Game::getPieceCount(Piece::QUEEN ) * (Piece::WHITE == piece.getColor()))) << 2u); break;
        case Piece::ROOK  : Game::getMemorySegment(Game::CAPTURED_OFFICERS)[1] |= 1u << ((piece.getIndex() + (Game::getPieceCount(Piece::ROOK  ) * (Piece::WHITE == piece.getColor()))) << 4u); break;
    }
}

void Game::setEnPassantPawn(Pawn const pawn) {
    unsigned char *const data = Game::getMemorySegment(Game::EN_PASSANT);

    *data &= 0xF0u;
    *data |= pawn.getIndex() << (Piece::WHITE == pawn.getColor());
}

void Game::setPawnPromotion(Pawn pawn, Piece::Type const type) {
    unsigned char *const data = pawn.getData();

    *data &= 0x3Fu;
    switch (type) {
        case Piece::BISHOP: *data |= 0x0u << 6u; break;
        case Piece::KNIGHT: *data |= 0x1u << 6u; break;
        case Piece::QUEEN : *data |= 0x2u << 6u; break;
        case Piece::ROOK  : *data |= 0x3u << 6u; break;

        case Piece::KING: case Piece::PAWN: break;
    }
}

void Game::setTurn(Piece::Color const color) {
    if (Piece::BLACK == color) *Game::getMemorySegment(Game::TURN) &= 0xFEu;
    if (Piece::WHITE == color) *Game::getMemorySegment(Game::TURN) |= 0x01u;
}

// : Piece ...
Piece::Color Piece::getColor(void) const {
    unsigned char const *const data = this -> getData();

    for (Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = Game::getPieceCount(type); iterator--; ) {
        if (data == Game::getPiece(Piece::BLACK, type, iterator).getData()) return Piece::BLACK;
        if (data == Game::getPiece(Piece::WHITE, type, iterator).getData()) return Piece::WHITE;
    }

    return static_cast<Color>(0x0u);
}

unsigned char Piece::getColumn(void) const {
    if (Piece::BISHOP == this -> getType()) return (this -> getPosition() % Game::getColumnCount()) + (this -> getRow() & 1u
        ? 0u == this -> getIndex() || 4u == this -> getIndex()
        : 1u == this -> getIndex() || 2u == this -> getIndex()
    );

    return this -> getPosition() >> 3u;
}

unsigned char* Piece::getData(void) const {
    return this -> data;
}

signed char Piece::getIndex(void) const {
    unsigned char const *const data = this -> getData();

    for (Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = Game::getPieceCount(type); iterator--; ) {
        if (
            data == Game::getPiece(Piece::BLACK, type, iterator).getData() ||
            data == Game::getPiece(Piece::WHITE, type, iterator).getData()
        ) return iterator;
    }

    return -1;
}

unsigned char Piece::getPosition(void) const {
    Type const type = this -> getType();

    switch (type) {
        case Piece::BISHOP: return *(this -> getData()) & 0x1F;
        case Piece::KNIGHT: case Piece::PAWN: case Piece::ROOK: return *(this -> getData()) & 0x7Fu;
        case Piece::KING: case Piece::QUEEN: {
            Color const color = this -> getColor();
            return (
                ((*Game::getPiece(color, Piece::BISHOP, Piece::QUEEN == type).getData() >> 6u) << 4u) |
                ((*Game::getPiece(color, Piece::KNIGHT, Piece::QUEEN == type).getData() >> 6u) << 2u) |
                ((*Game::getPiece(color, Piece::ROOK  , Piece::QUEEN == type).getData() >> 6u) << 0u)
            );
        } break;
    }

    return 0u;
}

unsigned char Piece::getRow(void) const {
    if (Piece::BISHOP == this -> getType()) return this -> getPosition() >> 3u;
    return this -> getPosition() & 0x7u;
}

Piece::Type Piece::getType(void) const {
    unsigned char const *const data = this -> getData();

    for (Type type = Piece::BISHOP; type <= Piece::ROOK; type = static_cast<Type>(static_cast<int>(type) + 1))
    for (unsigned char iterator = Game::getPieceCount(type); iterator--; ) {
        if (
            data == Game::getPiece(Piece::BLACK, type, iterator).getData() ||
            data == Game::getPiece(Piece::WHITE, type, iterator).getData()
        ) return type;
    }

    return static_cast<Type>(0u);
}

void Piece::setColumn(unsigned char const column) {
    this -> setPosition(column, this -> getRow());
}

void Piece::setPosition(unsigned char const column, unsigned char const row) {
    unsigned char *const data = this -> getData();
    Type const type = this -> getType();

    switch (type) {
        case Piece::BISHOP: {
            unsigned char const index = this -> getIndex();
            unsigned char position = 0u;

            while (position < Game::getTileCount()) {
                unsigned char const positionRow = position >> 3u;
                unsigned char const positionColumn = (position % Game::getColumnCount()) + (positionRow & 1u
                    ? 0u == index || 4u == index
                    : 1u == index || 2u == index
                );

                if (column == positionColumn && row == positionRow) {
                    *data &= 0xE0;
                    *data |= position;

                    break;
                }

                position += 2u;
            }
        } break;

        case Piece::KNIGHT: case Piece::PAWN: case Piece::ROOK: {
            *data &= 0xC0u;
            *data |= row | (column << 3u);
        } break;

        case Piece::KING: case Piece::QUEEN: {
            Color const color = this -> getColor();
            unsigned char *const position[3] = {
                Game::getPiece(color, Piece::BISHOP, Piece::QUEEN == type).getData(),
                Game::getPiece(color, Piece::KNIGHT, Piece::QUEEN == type).getData(),
                Game::getPiece(color, Piece::ROOK  , Piece::QUEEN == type).getData()
            };

            *position[0] &= 0x3Fu;
            *position[1] &= 0x3Fu;
            *position[2] &= 0x3Fu;

            *position[0] |= (column >> 1u)                << 6u;
            *position[1] |= ((column & 1u) | (row >> 2u)) << 6u;
            *position[2] |= (row & 0x3u)                  << 6u;
        } break;
    }
}

void Piece::setRow(unsigned char const row) {
    this -> setPosition(this -> getColumn(), row);
}

// : Program ...
void Program::exit(void) { Program::exit(Program::EXIT_CODE); }
void Program::exit(int const code) {
    Program::EXIT_CODE = code;

    if (NULL != Program::onexit) Program::onexit();
    std::exit(Program::EXIT_CODE);
}

void Program::raise(int const signal) {
    switch (signal) {
        case SIGABRT: if (NULL != Program::onabort) Program::onabort(); break;
        case SIGFPE: if (NULL != Program::onmathfault) Program::onmathfault(); break;
        case SIGILL: if (NULL != Program::oninvalidfault) Program::oninvalidfault(); break;
        case SIGINT: if (NULL != Program::oninterrupt) Program::oninterrupt(); break;
        case SIGSEGV: if (NULL != Program::onsegfault) Program::onsegfault(); break;
        case SIGTERM: if (NULL != Program::onterminate) Program::onterminate(); break;
    } Program::exit(Program::EXIT_CODE);
}

/* Main */
int WinMain(HINSTANCE const programHandle, HINSTANCE const programPreviousHandle, LPSTR const commandLineArguments, int const appearance) {
    // ... ->> Setup before calling `INITIATE`.
    Program::ARGUMENTS = commandLineArguments;
    Program::HANDLE = programHandle;
    Program::PREVIOUS_HANDLE = programPreviousHandle;
    Window::APPEARANCE = appearance;

    std::atexit(static_cast<void (*)(void)>(&Program::exit));
    std::signal(SIGABRT, &Program::raise);
    std::signal(SIGFPE, &Program::raise);
    std::signal(SIGILL, &Program::raise);
    std::signal(SIGINT, &Program::raise);
    std::signal(SIGSEGV, &Program::raise);
    std::signal(SIGTERM, &Program::raise);

    // ...
    INITIATE();
    return Program::EXIT_CODE;
}

/* Phase --- WARN (Lapys) -> All phases except `INITIATE()` can be invoked by the user. */
/* : Initiate */
void INITIATE(...) {
    bool programAlreadyRunning = false;
    HANDLE const currentProcessHandle = ::GetCurrentProcess();

    // ... ->> Configuration
    Program::onexit = static_cast<void (*)(void)>(&TERMINATE);
    Program::FILE_NAME = ::GetModuleFileName(NULL, Program::FILE_NAME, MAX_PATH), Program::FILE_NAME;
    Program::Lock::FILE_NAME = "ChessLockFile.tmp";
    Program::Lock::MUTEX_NAME = "ChessLockMutex";

    Window::BACKGROUND = ::GetSysColorBrush(COLOR_WINDOWTEXT); // --> ::GetSysColorBrush(COLOR_WINDOW)
    Window::CURSOR = static_cast<HCURSOR>(::LoadCursor(static_cast<HINSTANCE>(currentProcessHandle), IDC_ARROW)); // --> static_cast<HCURSOR>(::LoadImage(NULL, MAKEINTRESOURCE(OCR_NORMAL), IMAGE_CURSOR, 0, 0, LR_DEFAULTCOLOR | LR_DEFAULTSIZE | LR_SHARED))
    Window::ICON = static_cast<HICON>(::ExtractIcon(static_cast<HINSTANCE>(currentProcessHandle), Program::FILE_NAME, 0u));
    Window::STYLE = WS_POPUP;
    Window::TITLE = "Chess";

    // Logic ->> Assert previous program instance
    if (NULL != Program::PREVIOUS_HANDLE) programAlreadyRunning = true;
    else do {
        // ... ->> Mutex lock
        if (false == programAlreadyRunning)
        if (NULL != Program::Lock::MUTEX_NAME) {
            Program::Lock::MUTEX = ::CreateMutex(NULL, TRUE, Program::Lock::MUTEX_NAME);

            if (NULL != Program::Lock::MUTEX) {
                programAlreadyRunning = ERROR_ALREADY_EXISTS == ::GetLastError();
                break;
            }
        }

        // ... ->> File lock
        if (false == programAlreadyRunning)
        if (NULL != Program::Lock::FILE_NAME) {
            DWORD length;
            CHAR path[MAX_PATH + 17u] = {0};

            length = ::GetTempPath(MAX_PATH + 1u, path);
            if (0u != length) {
                for (CHAR const *name = Program::Lock::FILE_NAME; '\0' != *name; ++name) path[length++] = *name;
                Program::Lock::FILE = ::CreateFile(path, DELETE | GENERIC_READ | GENERIC_WRITE, 0x0u, NULL, CREATE_NEW, FILE_FLAG_DELETE_ON_CLOSE, NULL);

                if (INVALID_HANDLE_VALUE != Program::Lock::FILE) {
                    programAlreadyRunning = ERROR_FILE_EXISTS == ::GetLastError();
                    break;
                }
            }
        }
    } while (false);

    // Logic ... ->> Create or focus the program window
    if (programAlreadyRunning) {
        FLASHWINFO flashInformation;
        HWND const programPreviousWindowHandle = ::FindWindowEx(NULL /* --> HWND_DESKTOP */, NULL, Window::CLASS_NAME, Window::TITLE);

        // ...
        flashInformation.cbSize = sizeof(FLASHWINFO);
        flashInformation.dwFlags = FLASHW_CAPTION | FLASHW_TRAY;
        flashInformation.dwTimeout = 0u;
        flashInformation.hwnd = programPreviousWindowHandle;
        flashInformation.uCount = 2u;

        ::FlashWindowEx(&flashInformation);
        if (FALSE != ::ShowWindow(programPreviousWindowHandle, SW_RESTORE)) ::SetForegroundWindow(programPreviousWindowHandle);
        if (NULL != ::SetActiveWindow(programPreviousWindowHandle)) ::SetFocus(programPreviousWindowHandle);
    }

    else {
        WNDCLASSEX classInformation;

        // ...
        classInformation.cbClsExtra = 0;
        classInformation.cbSize = sizeof(WNDCLASSEX);
        classInformation.cbWndExtra = 0;
        classInformation.hbrBackground = Window::BACKGROUND;
        classInformation.hCursor = Window::CURSOR;
        classInformation.hIcon = Window::ICON;
        classInformation.hIconSm = Window::FAVICON;
        classInformation.hInstance = Program::HANDLE;
        classInformation.lpfnWndProc = &Window::PROCEDURE;
        classInformation.lpszClassName = Window::CLASS_NAME;
        classInformation.lpszMenuName = static_cast<LPCSTR>(NULL);
        classInformation.style = Window::CLASS_STYLE;

        // ...
        if (0x0 == ::RegisterClassEx(const_cast<WNDCLASSEX const*>(&classInformation)))
            TERMINATE("Unable to setup game window");

        else {
            if (Window::HEIGHT == -1 || Window::LEFT == -1 || Window::TOP == -1 || Window::WIDTH == -1) {
                RECT workareaBounds; ::SystemParametersInfo(SPI_GETWORKAREA, 0u, static_cast<PVOID>(&workareaBounds), 0x0);

                // ...
                Window::WIDTH = ((workareaBounds.right - workareaBounds.left) * 3) / 4;
                Window::HEIGHT = ((workareaBounds.bottom - workareaBounds.top) * 3) / 4;

                Window::LEFT = (((workareaBounds.right - workareaBounds.left) - Window::WIDTH) * 1) / 2;
                Window::TOP = (((workareaBounds.bottom - workareaBounds.top) - Window::HEIGHT) * 1) / 2;
            }

            Window::HANDLE = ::CreateWindowEx(
                Window::STYLE_EXTENSION, Window::CLASS_NAME, Window::TITLE, Window::STYLE,
                Window::LEFT, Window::TOP, Window::WIDTH, Window::HEIGHT,
                NULL /* --> HWND_DESKTOP */, static_cast<HMENU>(NULL), Program::HANDLE,
                reinterpret_cast<LPVOID>(static_cast<LPARAM>(Window::APPEARANCE))
            );

            // ...
            if (NULL == Window::HANDLE)
                TERMINATE("Unable to create game window");

            else for (BOOL threadMessageAvailable; WM_QUIT != Program::THREAD_MESSAGE.message; UPDATE()) {
                threadMessageAvailable = ::PeekMessage(&Program::THREAD_MESSAGE, NULL, 0x0, 0x0, PM_REMOVE);
                if (FALSE != threadMessageAvailable) ::DispatchMessage(&Program::THREAD_MESSAGE);

                Program::EXIT_CODE = Program::THREAD_MESSAGE.wParam;
            }
        }
    }
}

/* : Update */
void UPDATE(void) {
}

LRESULT CALLBACK UPDATE(HWND const windowHandle, UINT const message, WPARAM const parameter, LPARAM const subparameter) {
    return ::DefWindowProc(windowHandle, message, parameter, subparameter);
}

/* : Terminate */
void TERMINATE(void) { TERMINATE(NULL); }
void TERMINATE(char const message[]) {
    if (NULL != Program::Lock::BUFFER) ::CloseHandle(Program::Lock::BUFFER);
    if (NULL != Program::Lock::FILE && INVALID_HANDLE_VALUE != Program::Lock::FILE) ::CloseHandle(Program::Lock::FILE);
    if (NULL != Program::Lock::MUTEX) ::CloseHandle(Program::Lock::MUTEX);

    if (NULL != Window::CURSOR) ::DestroyCursor(Window::CURSOR);
    ::UnregisterClass(Window::CLASS_NAME, Program::HANDLE);

    // Logic ->> `TERMINATE(...)` called by the user.
    if (NULL != message) {
        Program::EXIT_CODE = EXIT_FAILURE;

        ::MessageBox(NULL, message, NULL /* --> "Error" */, MB_APPLMODAL | MB_DEFBUTTON1 | MB_ICONERROR | MB_OK | MB_SETFOREGROUND);
        Program::exit();
    }
}