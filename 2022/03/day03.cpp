#include "day03.hpp"

#include <string.h>

#include <fstream>
#include <iostream>
#include <iterator>
#include <map>
#include <sstream>
#include <vector>

DayThree::DayThree(std::string filename) {
    this->filename = filename;

    std::vector<std::vector<std::string>> input = this->parse_input(filename);
    std::map<char, int> map;
    char letterLow = 'a';
    char letterUpper = 'A';
    for (int i = 1; i < 27; i++) {
        // std::cout << letterLow << " " << i<< "  " << letterUpper << " " << (i+26) << "\n";
        map[letterLow] = i;
        map[letterUpper] = 26 + i;
        letterLow++;
        letterUpper++;
    }

    this->part_one = this->calculate_scoreA(input, map);
    this->part_two = this->calculate_scoreB(input, map);
}
DayThree::DayThree(std::string filename, char part) {
    this->filename = filename;

    std::vector<std::vector<std::string>> input = this->parse_input(filename);
    std::map<char, int> map;
    char letterLow = 'a';
    char letterUpper = 'A';
    for (int i = 1; i < 27; i++) {
        // std::cout << letterLow << " " << i<< "  " << letterUpper << " " << (i+26) << "\n";
        map[letterLow] = i;
        map[letterUpper] = 26 + i;
        letterLow++;
        letterUpper++;
    }
    switch (part) {
        case '1':
            this->part_one = this->calculate_scoreA(input, map);
            break;
        case '2':
            this->part_two = this->calculate_scoreB(input, map);
            break;
        case 'b':
            this->part_one = this->calculate_scoreA(input, map);
            this->part_two = this->calculate_scoreB(input, map);
            break;
        default:
            break;
    }
}
int DayThree::calculate_scoreA(std::vector<std::vector<std::string>> input, std::map<char, int> map) {
    int result = 0;
    for (auto rucksack : input) {
        std::string firstCompartment = rucksack[0];
        std::string secondCompartment = rucksack[1];
        int add = 0;
        for (char item : firstCompartment) {
            if (secondCompartment.find(item) < secondCompartment.length()) {
                int score = map[item];
                if (add < score) {
                    add = score;
                }
            }
        }
        result += add;
    }
    return result;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayThree::calculate_scoreB(std::vector<std::vector<std::string>> input, std::map<char, int> map) {
    int result = 0;
    for (int i = 0; i < input.size() / 3; i++) {
        // std::cout << i << '\n';
        int pos = i * 3;
        std::string firstRucksack = input[pos][0] + input[pos][1];
        std::string secondRucksack = input[pos + 1][0] + input[pos + 1][1];
        std::string thirdRucksack = input[pos + 2][0] + input[pos + 2][1];

        int containsA[52] = {0};
        int containsB[52] = {0};
        int containsC[52] = {0};

        int add = 0;
        for (char item : firstRucksack) {
            containsA[map[item] - 1]++;
        }
        for (char item : secondRucksack) {
            containsB[map[item] - 1]++;
        }
        for (char item : thirdRucksack) {
            containsC[map[item] - 1]++;
        }
        for (int j = 0; j < 52; j++) {
            if (containsA[j] >= 1 && containsB[j] >= 1 && containsC[j] >= 1) {
                // std::cout << "All contain "<<j<<'\n';
                add = j + 1;
            }
        }
        result += add;
    }
    return result;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::vector<std::vector<std::string>> DayThree::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::vector<std::string>> input;
    std::string line;
    while (std::getline(file, line)) {
        std::string half = line.substr(0, line.length() / 2);
        std::string otherHalf = line.substr(line.length() / 2);
        std::vector<std::string> rucksack;
        rucksack.push_back(half);
        rucksack.push_back(otherHalf);

        input.push_back(rucksack);
    }

    return input;
}

int DayThree::getPartOne() {
    return this->part_one;
}
int DayThree::getPartTwo() {
    return this->part_two;
}