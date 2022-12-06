#include <string>

class DayOne {
   public:
    DayOne(std::string filename);
    DayOne(std::string filename, char part);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int* parse_input(std::string& filename);
};
