#include <map>
#include <string>
#include <vector>
#include <stack>
class DayFive {
   public:
    DayFive(std::string filename);
    DayFive(std::string filename, char part);
    std::string getPartOne();
    std::string getPartTwo();

   private:
    std::string filename;
    std::string part_one;
    std::string part_two;

    std::string calculate_scoreA(std::vector<std::stack<char>> piles, std::vector<std::vector<int>> instructions);
    std::string calculate_scoreB(std::vector<std::stack<char>> piles, std::vector<std::vector<int>> instructions);
    std::vector<std::stack<char>> parse_input(std::string &filename);
};
