#include "day05.hpp"

#include <algorithm>
#include <cctype>
#include <fstream>
#include <iostream>
#include <iterator>
#include <locale>
#include <map>
#include <sstream>
#include <stack>
#include <string>
#include <vector>

DayFive::DayFive(std::string filename) {
    this->filename = filename;
    std::ifstream file(filename);
    std::vector<std::stack<char>> input;
    std::vector<std::string> crates;
    std::string line;
    bool move = false;
    bool init = false;

    // Create Start Stack:
    while (std::getline(file, line) && !move) {
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
            std::string crateLabel = line.substr(4 * i + 1, 1);

            char crate = crateLabel[0];
            if (crate != ' ' && crate != '1') {
                crates[i] += crate;
            }
            if (crate == '1') {
                move = true;
                break;
            }
        }
    }
    // Build actual stacks:
    for (int i = 0; i < input.size(); i++) {
        std::string pile = crates[i];
        int n = pile.length();
        for (int i = 0; i < n / 2; i++) {
            std::swap(pile[i], pile[n - i - 1]);
        }
        for (char c : pile) {
            input[i].push(c);
        }
    }

    // Create instructions vector
    std::vector<std::vector<int>> instructions;
    while (std::getline(file, line)) {
        // std::cout << "Working on [" << line << "]\n";
        if (!line.empty()) {
            line.erase(0, 5);
            line.erase(std::remove_if(line.begin(), line.end(),
                                      [](auto const& c) -> bool { return std::isalpha(c); }),
                       line.end());

            std::vector<int> instruction;
            int i;
            std::stringstream ss(line);
            while (ss >> i) {
                instruction.push_back(i);
            }
            instructions.push_back(instruction);
        }
    }

    this->part_one = this->calculate_scoreA(input, instructions);
    this->part_two = this->calculate_scoreB(input, instructions);
}

DayFive::DayFive(std::string filename, char part) {
    this->filename = filename;
    std::ifstream file(filename);
    std::vector<std::stack<char>> input;
    std::vector<std::string> crates;
    std::string line;
    bool move = false;
    bool init = false;

    // Create Start Stack:
    while (std::getline(file, line) && !move) {
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
            std::string crateLabel = line.substr(4 * i + 1, 1);

            char crate = crateLabel[0];
            if (crate != ' ' && crate != '1') {
                crates[i] += crate;
            }
            if (crate == '1') {
                move = true;
                break;
            }
        }
    }
    // Build actual stacks:
    for (int i = 0; i < input.size(); i++) {
        std::string pile = crates[i];
        int n = pile.length();
        for (int i = 0; i < n / 2; i++) {
            std::swap(pile[i], pile[n - i - 1]);
        }
        for (char c : pile) {
            input[i].push(c);
        }
    }

    // Create instructions vector
    std::vector<std::vector<int>> instructions;
    while (std::getline(file, line)) {
        // std::cout << "Working on [" << line << "]\n";
        if (!line.empty()) {
            line.erase(0, 5);
            line.erase(std::remove_if(line.begin(), line.end(),
                                      [](auto const& c) -> bool { return std::isalpha(c); }),
                       line.end());

            std::vector<int> instruction;
            int i;
            std::stringstream ss(line);
            while (ss >> i) {
                instruction.push_back(i);
            }
            instructions.push_back(instruction);
        }
    }

    switch (part) {
        case '1':
            this->part_one = this->calculate_scoreA(input, instructions);
            break;
        case '2':
            this->part_two = this->calculate_scoreB(input, instructions);
            break;
        case 'b':
            this->part_one = this->calculate_scoreA(input, instructions);
            this->part_two = this->calculate_scoreB(input, instructions);
            break;

        default:
            break;
    }
}


std::string DayFive::calculate_scoreA(std::vector<std::stack<char>> piles, std::vector<std::vector<int>> instructions) {
    for (std::vector<int> instruction : instructions) {
        for (int i = 0; i < instruction[0]; i++) {
            char first = piles[instruction[1] - 1].top();
            piles[instruction[1] - 1].pop();
            piles[instruction[2] - 1].push(first);
        }
    }

    std::string result = "";
    for (std::stack<char> s : piles) {
        if (!s.empty()) {
            result += s.top();
        }
    }
    return result;
}

std::string DayFive::calculate_scoreB(std::vector<std::stack<char>> piles, std::vector<std::vector<int>> instructions) {
    std::string result = "";
    for (std::vector<int> instruction : instructions) {
        std::string bundle = "";
        for (int i = 0; i < instruction[0]; i++) {
            bundle += piles[instruction[1] - 1].top();
            piles[instruction[1] - 1].pop();
        }
        int n = bundle.length();
        for (int i = 0; i < n / 2; i++) {
            std::swap(bundle[i], bundle[n - i - 1]);
        }
        for (char c : bundle) {
            piles[instruction[2] - 1].push(c);
        }
    }

    for (std::stack<char> s : piles) {
        if (!s.empty()) {
            result += s.top();
        }
    }

    return result;
}

/*
    Parses the input for day 3.
    @param filename The name of the file.
    @return Parsed input of day 3.
*/
std::vector<std::stack<char>> DayFive::parse_input(std::string& filename) {
    std::ifstream file(filename);
    std::vector<std::stack<char>> input;
    std::vector<std::string> crates;
    std::string line;
    bool move = false;
    bool init = false;
    while (std::getline(file, line) && !move) {
        // std::cout << line << "\n";
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
        int n = pile.length();
        for (int i = 0; i < n / 2; i++) {
            std::swap(pile[i], pile[n - i - 1]);
        }
        std::cout << "Pile " << i << ": ";
        for (char c : pile) {
            std::cout << c << " ";
            input[i].push(c);
        }
        std::cout << '\n';
    }
    std::vector<std::vector<int>> instructions;
    while (std::getline(file, line)) {
        // std::cout << "Working on [" << line << "]\n";
        if (!line.empty()) {
            line.erase(0, 5);
            line.erase(std::remove_if(line.begin(), line.end(),
                                      [](auto const& c) -> bool { return std::isalpha(c); }),
                       line.end());
            std::cout << "Converted to [" << line << "]\n";
            std::vector<int> instruction;
            int i;
            std::stringstream ss(line);
            while (ss >> i) {
                instruction.push_back(i);
            }
            instructions.push_back(instruction);
            std::cout << "Instruction: move " << instruction[0] << " from " << instruction[1] << " to " << instruction[2] << "\n";
            for (int i = 0; i < instruction[0]; i++) {
                char first = input[instruction[1] - 1].top();
                input[instruction[1] - 1].pop();
                input[instruction[2] - 1].push(first);

                std::cout << "Moved " << first << " from Stack " << instruction[1] - 1 << " to " << instruction[2] - 1 << "\n";
                std::cout << "-------------------\n";
            }

            std::cout << '\n';
        }
    }

    return input;
}

std::string DayFive::getPartOne() {
    return this->part_one;
}
std::string DayFive::getPartTwo() {
    return this->part_two;
}