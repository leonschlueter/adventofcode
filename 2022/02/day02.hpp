#include <string>
#include <vector>

class DayTwo {
   public:
    DayTwo(std::string filename);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int calculate_scoreA(std::vector<int> match);
    int calculate_scoreB(std::vector<int> match);
    std::vector<std::vector<int>> parse_input(std::string &filename);
};
