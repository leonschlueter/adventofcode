#include <string>
#include <vector>

struct folder{
    std::string name;
    std::vector<folder> folders;
    folder* previous;
    int file_size = 0;
};

class DaySeven {
   public:
    DaySeven(std::string filename);
    int getPartOne();
    int getPartTwo();

   private:
    std::string filename;
    int part_one;
    int part_two;
    std::vector<std::pair<std::string, int>> l;
    void calculate_scoreA(folder* root);
    void calculate_scoreB(folder* root);
    folder parse_input(std::string &filename);
};

