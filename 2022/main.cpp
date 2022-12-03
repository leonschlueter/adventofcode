#include "main.hpp"

#include "01/day01.hpp"
#include "02/day02.hpp"
#include "03/day03.hpp"

#include <iostream>

int main(int argc, char const *argv[]) {
    std::cout << "Advent Of Code 2022\n";
    int total = 47;
    int header_len = 0;
    for (size_t i = 0; i < total; i++) {
        std::cout << "\033[1;35m"
                  << "-"
                  << "\033[1;0m";
    }
    std::cout << "\n";
    std::cout << "\033[1;35m"
              << "|"
              << "\033[0;1m"
              << " Day "
                 "\033[1;35m"
              << "|"
              << "\033[0m";

    header_len += 7;
    int part_space = (total - 7 - 2) / 2;
    for (int i = 0; i < part_space - 7; i++) {
        std::cout << " ";
    }
    std::cout << "\033[0;1m"
              << "Part 1 "
              << "\033[1;35m"
              << "|"
              << "\033[1;0m";
    for (int i = 0; i < part_space - 7; i++) {
        std::cout << " ";
    }
    std::cout << "\033[0;1m"
              << "Part 2 "
              << "\033[1;35m"
              << "|"
              << "\033[0m\n";
    for (size_t i = 0; i < total; i++) {
        std::cout << "\033[1;35m"
                  << "-"
                  << "\033[0m";
    }
    std::cout << "\n";

    // Instantiate different Day classes
    DayOne dayOne("01/01");
    DayTwo dayTwo("02/02");
    DayThree dayThree("03/03");


    // Print line per day:
    int one_a = dayOne.getPartOne();
    int one_b = dayOne.getPartTwo();
    print_sol_line("01", one_a, one_b, part_space, 1);

    int two_a = dayTwo.getPartOne();
    int two_b = dayTwo.getPartTwo();
    print_sol_line("02", two_a, two_b, part_space, 1);

    int three_a = dayThree.getPartOne();
    int three_b = dayThree.getPartTwo();
    print_sol_line("03", three_a, three_b, part_space, 1);

    print_sol_line("04", 0, 0, part_space, 0);
    print_sol_line("05", 0, 0, part_space, 0);
    print_sol_line("06", 0, 0, part_space, 0);
    print_sol_line("07", 0, 0, part_space, 0);
    print_sol_line("08", 0, 0, part_space, 0);
    print_sol_line("09", 0, 0, part_space, 0);
    print_sol_line("10", 0, 0, part_space, 0);

     for (size_t i = 0; i < total; i++) {
        std::cout << "\033[1;35m"
                  << "-"
                  << "\033[0m";
    }
    std::cout << "\n";
    return 0;
}

void print_sol_line(std::string day, int a, int b, int part_space, int color) {
    int len = 0;
    int a_space = part_space - std::to_string(a).length();
    int b_space = part_space - std::to_string(b).length();
    std::string col = "\033[0m";
    if (color == 0) {
        col = "\033[0m";
    } else if (color == 1) {
        col = "\033[32m";
    }
    std::cout << "\033[1;35m"
              << "|"
              << "\033[0m "
              << day
              << "  \033[1;35m"
              << "|"
              << "\033[0m";

    for (int i = 0; i < a_space - 1; i++) {
        std::cout << " ";
    }
    std::cout << col << a << " \033[1;35m"
              << "|"
              << "\033[0m";

    for (int i = 0; i < b_space - 1; i++) {
        std::cout << " ";
    }
    std::cout << col << b << " \033[1;35m"
              << "|"
              << "\033[0m\n";
}