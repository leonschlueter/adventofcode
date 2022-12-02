#include <bits/stdc++.h>

class DayOne{
public:
DayOne(std::string filename);
int getPartOne(); 
int getPartTwo();

private:
std::string filename; 
int part_one; 
int part_two;

int* parse_input(std::string &filename);
};
