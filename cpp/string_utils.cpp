#include <string>
#include <cctype>

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

bool isNumeric(const std::string& value) {
    if (value.empty()) return false;
    for (char character : value) {
        if (!std::isdigit(static_cast<unsigned char>(character))) return false;
    }
    return true;
}
