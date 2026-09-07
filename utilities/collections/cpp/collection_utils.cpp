#include <algorithm>
#include <vector>

std::vector<int> uniqueValues(const std::vector<int>& values) {
    std::vector<int> result = values;
    std::sort(result.begin(), result.end());
    result.erase(std::unique(result.begin(), result.end()), result.end());
    return result;
}

int sum(const std::vector<int>& values) {
    int total = 0;
    for (int value : values) total += value;
    return total;
}

double average(const std::vector<int>& values) {
    if (values.empty()) return 0.0;
    return static_cast<double>(sum(values)) / values.size();
}
