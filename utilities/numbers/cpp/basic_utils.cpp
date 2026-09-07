#include <algorithm>

int clamp(int value, int min, int max) {
    return std::min(std::max(value, min), max);
}
