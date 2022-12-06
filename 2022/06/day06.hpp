#include <map>
#include <string>
#include <vector>
class DaySix {
   public:
    DaySix(std::string filename);
    DaySix(std::string filename, char part);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;

    int calculate_scoreA(std::string input);
    int calculate_scoreB(std::string input);
    std::string parse_input(std::string &filename);
};
