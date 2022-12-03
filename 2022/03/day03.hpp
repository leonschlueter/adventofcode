#include <map>
#include <string>
#include <vector>
class DayThree {
   public:
    DayThree(std::string filename);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int calculate_scoreA(std::vector<std::vector<std::string>> input, std::map<char, int> map);
    int calculate_scoreB(std::vector<std::vector<std::string>> input, std::map<char, int> map);
    std::vector<std::vector<std::string>> parse_input(std::string &filename);
};
