#include <cctype>
#include <string>

// Note: toLower and toUpper perform byte-by-byte ASCII case conversion using
// std::tolower/std::toupper. Multi-byte UTF-8 sequences and non-ASCII characters
// are passed through unmodified without full Unicode case folding.
std::string toLower(std::string value) {
    for (char& character : value) {
        character = static_cast<char>(std::tolower(static_cast<unsigned char>(character)));
    }
    return value;
}

std::string toUpper(std::string value) {
    for (char& character : value) {
        character = static_cast<char>(std::toupper(static_cast<unsigned char>(character)));
    }
    return value;
}
