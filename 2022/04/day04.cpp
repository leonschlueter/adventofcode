#include "day04.hpp"
#include <string.h>
#include <vector>
#include <sstream>
#include <fstream>
#include <map>
#include <iostream>
#include <iterator>

DayFour::DayFour(std::string filename){
    this->filename = filename;
    
    std::vector<std::vector<std::string>> input = this->parse_input(filename);
   

    this->part_one = this->calculate_scoreA(input);
    this->part_two = this->calculate_scoreB(input);
   
}



int DayFour::calculate_scoreA(std::vector<std::vector<std::string>> input) {
    int result = 0;
   
    return result;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayFour::calculate_scoreB(std::vector<std::vector<std::string>> input) {
    int result = 0;
    
    return result;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::vector<std::vector<std::string>> DayFour::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::vector<std::string>> input;
    std::string line;
    while (std::getline(file, line)) {
       
    }

    return input;
}

int DayFour::getPartOne(){
    return this->part_one;
}
int DayFour::getPartTwo(){
    return this->part_two;
}