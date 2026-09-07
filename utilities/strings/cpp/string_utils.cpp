#include <cctype>
#include <string>

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
