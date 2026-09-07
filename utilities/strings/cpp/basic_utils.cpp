#include <algorithm>
#include <cctype>
#include <string>

bool isEmpty(const std::string& value) {
    return value.empty();
}

std::string capitalize(const std::string& value) {
    if (value.empty()) return value;
    std::string result = value;
    result[0] = static_cast<char>(std::toupper(static_cast<unsigned char>(result[0])));
    return result;
}

std::string reverseString(const std::string& value) {
    std::string result = value;
    std::reverse(result.begin(), result.end());
    return result;
}
