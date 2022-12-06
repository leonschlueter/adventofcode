#include "day06.hpp"

#include <fstream>
#include <iostream>
#include <set>
#include <string>
#include <vector>

DaySix::DaySix(std::string filename) {
    this->filename = filename;

    std::string input = this->parse_input(filename);

    this->part_one = this->calculate_scoreA(input);
    this->part_two = this->calculate_scoreB(input);
}

int DaySix::calculate_scoreA(std::string in) {
    for (int i = 0; i < in.length(); i++) {
        std::set<char> set;
        for (int j = 0; j < 4; j++) {
            if (i - j >= 0) {
                set.insert(in[i - j]);
            }
        }
        if (set.size() == 4) {
            return i + 1;
        }
    }

    return 0;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DaySix::calculate_scoreB(std::string in) {
    for (int i = 0; i < in.length(); i++) {
        std::set<char> set;
        for (int j = 0; j <= 13; j++) {
            if (i - j >= 0) {
                set.insert(in[i - j]);
            }
        }
        if (set.size() == 14) {
            return i + 1;
        }
    }

    return 0;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::string DaySix::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::string input;
    std::getline(file, input);
    return input;
}

int DaySix::getPartOne() {
    return this->part_one;
}
int DaySix::getPartTwo() {
    return this->part_two;
}