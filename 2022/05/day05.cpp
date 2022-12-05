#include "day05.hpp"

#include <fstream>
#include <iostream>
#include <iterator>
#include <map>
#include <sstream>
#include <stack>
#include <string>
#include <vector>

DayFive::DayFive(std::string filename) {
    this->filename = filename;

    std::vector<std::stack<char>> input = this->parse_input(filename);

    this->part_one = this->calculate_scoreA(input);
    this->part_two = this->calculate_scoreB(input);
}

int DayFive::calculate_scoreA(std::vector<std::stack<char>> input) {
    int result = 0;

    return result;
}

int DayFive::calculate_scoreB(std::vector<std::stack<char>> input) {
    int result = 0;

    return result;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::vector<std::stack<char>> DayFive::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::stack<char>> input;
    std::vector<std::string> crates;
    std::string line;
    bool move = false;
    bool init = false;
    while (std::getline(file, line) && !move) {
        std::cout << line << "\n";
        int amount = line.length() / 4;
        if (!init) {
            init = true;
            for (int i = 0; i <= amount; i++) {
                std::stack<char> stack;
                input.push_back(stack);
                crates.push_back("");
            }
        }
        for (int i = 0; i <= amount; i = i + 1) {
            // std::cout << (4*i+1) << '\n';
            std::string crateLabel = line.substr(4 * i + 1, 1);

            char crate = crateLabel[0];
            if (crate != ' ' && crate != '1') {
                crates[i] += crate;
                std::cout << "Added [" << crate << "]\n";
                std::cout << "Now " << crates[i] << "\n";
            }
            if (crate == '1') {
                std::cout << "Changed mode\n";
                move = true;
                break;
            }
        }
    }

    for (int i = 0; i < input.size(); i++) {
        std::string pile = crates[i];
        for (char c : pile) {
            input[i].push(c);
        }
    }

    while (std::getline(file, line)) {
        std::cout << "Working on ["<<line<< "]\n";
        if (!line.empty()) {
            line.replace(line.begin(), line.end(), "move ", "");
            line.replace(line.begin(), line.end(), "from", "");
            line.replace(line.begin(), line.end(), "to", "");
            std::vector<int> instruction;
            int i;
            std::stringstream ss(line);
            while (ss >> i) {
                instruction.push_back(i);
            }
            
            for(int i = 0; i < instruction[0]; i++){
                std::stack<char> pile_one = input[2];
                std::stack<char> pile_two = input[3];
                char first = pile_one.top();
                pile_one.pop();
                pile_two.push(first);
            }

        }
    }

    return input;
}

int DayFive::getPartOne() {
    return this->part_one;
}
int DayFive::getPartTwo() {
    return this->part_two;
}