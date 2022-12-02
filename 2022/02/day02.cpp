#include "day02.h"
#include <bits/stdc++.h>


int main(int argc, char const *argv[]) {
    std::cout << "========== DAY 2 ==========\n";
    if (argc != 2) {
        std::cout << "NOT ENOUGH ARGS \n";
    }
    std::string filename = argv[1];

    std::vector<std::vector<int>> input = parse_input(filename);
    int resultA = 0;
    int resultB = 0;
    for (auto vec : input) {
        resultA += calculate_scoreA(vec);
        resultB += calculate_scoreB(vec);
    }

    std::cout << "Part 1: " << resultA << "\n";
    std::cout << "Part 2: " << resultB << "\n";
    return 0;
}

/*
    Calculates the score of a vector<int> with length 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for both entries.
    @param match A vector<int> [a, b] of length 2, where a is the form of enemy and b is your form
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int calculate_scoreA(std::vector<int> match) {
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
int calculate_scoreB(std::vector<int> match) {
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
std::vector<std::vector<int>> parse_input(std::string &filename) {
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