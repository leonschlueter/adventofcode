#include "day01.h"

#include <bits/stdc++.h>

#include "../utils/aoc_utils.h"

int main(int argc, char const *argv[]) {
    std::cout << "========== DAY 1 ==========\n";
    if (argc != 2) {
        std::cout << "NOT ENOUGH ARGS \n";
    }
    std::string filename = argv[1];

    int* elves = parse_input(filename);
    std::sort(elves, elves+3);

    std::cout << "Part 1: " << elves[2] << "\n";
    std::cout << "Part 2: " << (elves[0] + elves[1] + elves[2]) << "\n";
    return 0;
}

/*
    Parses the given input file into an array with size 3, with three elves with the most food are stored.
    @param filename The name of the file.
    @return Array of size 3, with the amount of food of the 3 biggest elves. 
*/
int* parse_input(std::string &filename) {
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