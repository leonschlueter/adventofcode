#include "day01.hpp"

#include <fstream>
#include <sstream>
#include <string>
#include <vector>

#include "../utils/aoc_utils.h"

DayOne::DayOne(std::string filename) {
    this->filename = filename;
    int* elves = this->parse_input(filename);

    this->part_one = elves[2];
    this->part_two = elves[0] + elves[1] + elves[2];
}
DayOne::DayOne(std::string filename, char part) {
    this->filename = filename;
    int* elves = this->parse_input(filename);
    switch (part) {
        case '1':
            this->part_one = elves[2];
            break;
        case '2':
            this->part_two = elves[0] + elves[1] + elves[2];
            break;
        case 'b':
            this->part_one = elves[2];
            this->part_two = elves[0] + elves[1] + elves[2];
            break;

        default:
            break;
    }
}

/*
    Parses the given input file into an array with size 3, with three elves with the most food are stored.
    @param filename The name of the file.
    @return Array of size 3, with the amount of food of the 3 biggest elves.
*/
int* DayOne::parse_input(std::string& filename) {
    std::ifstream file(filename);
    int x = 0;
    static int arr[3] = {0, 0, 0};
    std::string line;
    while (std::getline(file, line, '\n')) {
        if (line.empty()) {
            if (x > arr[2]) {
                arr[0] = arr[1];
                arr[1] = arr[2];
                arr[2] = x;
            } else if (x > arr[1]) {
                arr[0] = arr[1];
                arr[1] = x;
            } else if (x > arr[0]) {
                arr[0] = x;
            }
            x = 0;
        } else {
            std::istringstream tmp(line);
            int num;
            tmp >> num;
            x += num;
        }
    }
    return arr;
}

int DayOne::getPartOne() {
    return this->part_one;
}
int DayOne::getPartTwo() {
    return this->part_two;
}