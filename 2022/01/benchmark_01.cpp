#include "day01.hpp"

int main(int argc, char const *argv[])
{
    std::string file = argv[1];
    char p = argv[2][0];
    DayOne dayOne(file, p);
    
    return 0;
}
