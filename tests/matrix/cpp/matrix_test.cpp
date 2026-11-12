#include <cassert>
#include <climits>
#include <string>
#include <vector>

std::vector<int> uniqueValues(const std::vector<int>& values);
int sum(const std::vector<int>& values);
double average(const std::vector<int>& values);
bool isEmpty(const std::string& value);
std::string capitalize(const std::string& value);
std::string reverseString(const std::string& value);
std::string toLower(std::string value);
std::string toUpper(std::string value);
int minValue(const std::vector<int>& values);
int maxValue(const std::vector<int>& values);
bool isNumeric(const std::string& value);

int main() {
    assert(uniqueValues({3, 1, 3, 2, 1}) == std::vector<int>({1, 2, 3}));
    assert(uniqueValues({}).empty());
    assert(uniqueValues({5}) == std::vector<int>({5}));
    assert(uniqueValues({2, 2, 2}) == std::vector<int>({2}));
    assert(uniqueValues({4, 3, 2, 1}) == std::vector<int>({1, 2, 3, 4}));

    assert(sum({1, 2, 3, 4}) == 10);
    assert(sum({}) == 0);
    assert(sum({-5, 5}) == 0);
    assert(sum({-2, -3, 5}) == 0);

    assert(average({1, 2, 3, 4}) == 2.5);
    assert(average({}) == 0.0);

    // Strings: isEmpty
    assert(isEmpty(""));
    assert(!isEmpty("text"));

    // Strings: capitalize
    assert(capitalize("") == "");
    assert(capitalize("hello") == "Hello");
    assert(capitalize("Hello") == "Hello");
    assert(capitalize("hELLO") == "HELLO");
    assert(capitalize("123abc") == "123abc");
    assert(capitalize("!hello") == "!hello");
    assert(capitalize(" hello") == " hello");
    // Non-ASCII UTF-8: byte-oriented pass-through (does not map Unicode code points)
    assert(capitalize("é") == "é");

    // Strings: toLower & toUpper
    assert(toLower("") == "");
    assert(toUpper("") == "");
    assert(toLower("HeLLo WoRLd 123!@#") == "hello world 123!@#");
    assert(toUpper("HeLLo WoRLd 123!@#") == "HELLO WORLD 123!@#");
    assert(toLower("already lower") == "already lower");
    assert(toUpper("ALREADY UPPER") == "ALREADY UPPER");
    assert(toLower("12345!@#$%^&*()") == "12345!@#$%^&*()");
    assert(toUpper("12345!@#$%^&*()") == "12345!@#$%^&*()");
    // Non-ASCII UTF-8: byte-oriented pass-through without modification
    assert(toLower("Café") == "café");
    assert(toUpper("Café") == "CAFé");

    // Strings: reverseString
    assert(reverseString("ABC") == "CBA");

    // Numbers: minValue
    assert(minValue({4, 2, 7}) == 2);
    assert(minValue({}) == 0);
    assert(minValue({0}) == 0);
    assert(minValue({-10, -5, -20}) == -20);
    assert(minValue({-5, 0, 5}) == -5);
    assert(minValue({4, 4, 4}) == 4);
    assert(minValue({INT_MIN, 0, INT_MAX}) == INT_MIN);

    // Numbers: maxValue
    assert(maxValue({4, 2, 7}) == 7);
    assert(maxValue({}) == 0);
    assert(maxValue({0}) == 0);
    assert(maxValue({-10, -5, -20}) == -5);
    assert(maxValue({-5, 0, 5}) == 5);
    assert(maxValue({4, 4, 4}) == 4);
    assert(maxValue({INT_MIN, 0, INT_MAX}) == INT_MAX);

    // Numbers: isNumeric
    assert(isNumeric("12.5"));
    assert(!isNumeric("12x"));
    assert(!isNumeric(""));
    assert(isNumeric("0"));
    assert(isNumeric("-0"));
    assert(isNumeric("-42"));
    assert(isNumeric("+42"));
    assert(isNumeric("0.0"));
    assert(isNumeric("-12.345"));
    assert(isNumeric("1e5"));
    assert(isNumeric("-2.5e-3"));
    assert(!isNumeric(" "));
    assert(!isNumeric("  12"));
    assert(!isNumeric("12  "));
    assert(!isNumeric("abc"));
    assert(!isNumeric("."));
    assert(!isNumeric("-"));
    assert(!isNumeric("--5"));
}
