#include "day02.hpp"
#include <bits/stdc++.h>

DayTwo::DayTwo(std::string filename){
    this->filename = filename;
    this->part_one = 0;
    this->part_two = 0;
    std::vector<std::vector<int>> input = this->parse_input(filename);
   
    for (auto vec : input) {
        
        this->part_one += this->calculate_scoreA(vec);
        this->part_two += this->calculate_scoreB(vec);
    }
}


/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for both entries.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b is your form
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayTwo::calculate_scoreA(std::vector<int> match) {
    
    int result = 0;
    int a = match[0];
    int b = match[1];
    result += b;
    if (a % 3 == b % 3) {
        result += 3;
    } else if ((a % 3) == ((b - 1) % 3)) {
        result += 6;
    }

    return result;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayTwo::calculate_scoreB(std::vector<int> match) {
    int result = 0;
    int a = match[0];
    int b = match[1];

    switch (b) {
        case 1:
            if (a == 1) {
                result = 3;
            } else {
                result = (a - 1) % 3;
            }
            break;
        case 2:
            result += a + 3;
            break;
        case 3:
            result += ((a % 3) + 1) + 6;
            break;
        default:
            break;
    }

    return result;
}

/*
    Parses the input for day 2.
    @param filename The name of the file.
    @return Parsed input of day 2.
*/
std::vector<std::vector<int>> DayTwo::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::vector<int>> input;
    std::string line;
    while (std::getline(file, line)) {
        char a, b;
        int enemy, myself;
        std::istringstream tmp(line);
        std::vector<int> li;
        tmp >> a;
        tmp >> b;
        a = a - 'A' + 1;
        b = b - 'X' + 1;

        li.push_back(a);
        li.push_back(b);
        input.push_back(li);
    }

    return input;
}

int DayTwo::getPartOne(){
    return this->part_one;
}
int DayTwo::getPartTwo(){
    return this->part_two;
}