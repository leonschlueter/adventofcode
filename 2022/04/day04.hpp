#include <string>
#include <vector>
#include <map>
class DayFour{
public:
DayFour(std::string filename);
int getPartOne(); 
int getPartTwo();

private:
std::string filename; 
int part_one; 
int part_two;

int calculate_scoreA(std::vector<std::vector<std::string>> input);
int calculate_scoreB(std::vector<std::vector<std::string>> input);
std::vector<std::vector<std::string>> parse_input(std::string &filename);
};
