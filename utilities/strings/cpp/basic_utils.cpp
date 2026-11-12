#include <algorithm>
#include <cctype>
#include <string>

// Note: This implementation performs byte-level ASCII case conversion using
// std::toupper on unsigned char. Multi-byte UTF-8 sequences and non-ASCII
// code points are left untouched as individual bytes without Unicode case mapping.
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
