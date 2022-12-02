#include <bits/stdc++.h>

class DayThree{
public:
DayThree(std::string filename);
int getPartOne(); 
int getPartTwo();

private:
std::string filename; 
int part_one; 
int part_two;

int calculate_scoreA();
int calculate_scoreB();
std::vector<std::vector<int>> parse_input(std::string &filename);
};
