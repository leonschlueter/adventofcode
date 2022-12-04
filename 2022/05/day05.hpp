#include <map>
#include <string>
#include <vector>
class DayFive {
   public:
    DayFive(std::string filename);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int calculate_scoreA(std::vector<std::vector<int>> input);
    int calculate_scoreB(std::vector<std::vector<int>> input);
    std::vector<std::vector<int>> parse_input(std::string &filename);
};
