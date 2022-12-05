#include <map>
#include <string>
#include <vector>
#include <stack>
class DayFive {
   public:
    DayFive(std::string filename);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int calculate_scoreA(std::vector<std::stack<char>> input);
    int calculate_scoreB(std::vector<std::stack<char>> input);
    std::vector<std::stack<char>> parse_input(std::string &filename);
};
