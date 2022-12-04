#include "day04.hpp"

#include <string.h>

#include <algorithm>
#include <fstream>
#include <iostream>
#include <iterator>
#include <map>
#include <sstream>
#include <vector>

DayFour::DayFour(std::string filename) {
    this->filename = filename;

    std::vector<std::vector<int>> input = this->parse_input(filename);

    this->part_one = this->calculate_scoreA(input);
    this->part_two = this->calculate_scoreB(input);
}


int DayFour::calculate_scoreA(std::vector<std::vector<int>> input) {
    int result = 0;
    for (std::vector<int> elf : input) {
        if (elf.size() == 4) {
            if (elf[0] <= elf[2] && elf[1] >= elf[3]) {
                result++;
            } else if (elf[0] >= elf[2] && elf[1] <= elf[3]) {
                result++;
            }
        }
    }
    return result;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayFour::calculate_scoreB(std::vector<std::vector<int>> input) {
    int result = 0;
    for (std::vector<int> elf : input) {
        if (elf.size() == 4) {
            if (elf[1] >= elf[2] && elf[0] <= elf[2]) {
                result++;
            } else if (elf[3] >= elf[0] && elf[2] <= elf[0]) {
                result++;
            }
        }
    }
    return result;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::vector<std::vector<int>> DayFour::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::vector<int>> input;
    std::string line;
    while (std::getline(file, line)) {
        std::vector<int> pair;
        std::replace(line.begin(), line.end(), '-', ' ');
        std::replace(line.begin(), line.end(), ',', ' ');
        std::stringstream ss(line);
        int i;
        while (ss >> i) {
            pair.push_back(i);
        }

        input.push_back(pair);
    }

    return input;
}

int DayFour::getPartOne() {
    return this->part_one;
}
int DayFour::getPartTwo() {
    return this->part_two;
}