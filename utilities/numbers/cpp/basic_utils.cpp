#include <algorithm>
#include <string>
#include <vector>

int minValue(const std::vector<int>& values) {
    if (values.empty()) return 0;
    return *std::min_element(values.begin(), values.end());
}

int maxValue(const std::vector<int>& values) {
    if (values.empty()) return 0;
    return *std::max_element(values.begin(), values.end());
}

bool isNumeric(const std::string& value) {
    if (value.empty()) return false;
    try {
        std::size_t position = 0;
        std::stod(value, &position);
        return position == value.size();
    } catch (...) {
        return false;
    }
}
