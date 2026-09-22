#include <cassert>
#include <string>
#include <vector>

std::vector<int> uniqueValues(const std::vector<int>& values);
int sum(const std::vector<int>& values);
double average(const std::vector<int>& values);
bool isEmpty(const std::string& value);
std::string capitalize(const std::string& value);
std::string reverseString(const std::string& value);
int minValue(const std::vector<int>& values);
int maxValue(const std::vector<int>& values);
bool isNumeric(const std::string& value);

int main() {
    assert(uniqueValues({3, 1, 3, 2, 1}) == std::vector<int>({1, 2, 3}));
    assert(sum({1, 2, 3, 4}) == 10);
    assert(average({1, 2, 3, 4}) == 2.5);
    assert(average({}) == 0.0);
    assert(isEmpty(""));
    assert(capitalize("hello") == "Hello");
    assert(reverseString("ABC") == "CBA");
    assert(minValue({4, 2, 7}) == 2);
    assert(maxValue({4, 2, 7}) == 7);
    assert(isNumeric("12.5"));
    assert(!isNumeric("12x"));
}
