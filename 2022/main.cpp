#include "main.hpp"

#include <chrono>
#include <iostream>

#include "01/day01.hpp"
#include "02/day02.hpp"
#include "03/day03.hpp"
#include "04/day04.hpp"
#include "05/day05.hpp"
#include "06/day06.hpp"
#include "07/day07.hpp"
#include "08/day08.hpp"
#include "template/dayX.hpp"

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
    std::vector<std::chrono::milliseconds> times;
    // Instantiate different Day classes
    auto t1 = std::chrono::high_resolution_clock::now();
    DayOne dayOne("01/01");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayTwo dayTwo("02/02");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayThree dayThree("03/03");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayFour dayFour("04/04");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayFive dayFive("05/05");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DaySix daySix("06/06");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DaySeven daySeven("07/07");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayEight dayEight("08/08");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    DayX dayX("");
    times.push_back(std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - t1));
    t1 = std::chrono::high_resolution_clock::now();
    // Print line per day:
    std::string one_a = std::to_string(dayOne.getPartOne());
    std::string one_b = std::to_string(dayOne.getPartTwo());
    print_sol_line("01", one_a, one_b, part_space, 1);

    std::string two_a = std::to_string(dayTwo.getPartOne());
    std::string two_b = std::to_string(dayTwo.getPartTwo());
    print_sol_line("02", two_a, two_b, part_space, 1);

    std::string three_a = std::to_string(dayThree.getPartOne());
    std::string three_b = std::to_string(dayThree.getPartTwo());
    print_sol_line("03", three_a, three_b, part_space, 1);

    std::string four_a = std::to_string(dayFour.getPartOne());
    std::string four_b = std::to_string(dayFour.getPartTwo());
    print_sol_line("04", four_a, four_b, part_space, 1);

    std::string five_a = dayFive.getPartOne();
    std::string five_b = dayFive.getPartTwo();
    print_sol_line("05", five_a, five_b, part_space, 1);

    std::string six_a = std::to_string(daySix.getPartOne());
    std::string six_b = std::to_string(daySix.getPartTwo());
    print_sol_line("06", six_a, six_b, part_space, 1);

    std::string seven_a = std::to_string(daySeven.getPartOne());
    std::string seven_b = std::to_string(daySeven.getPartTwo());
    print_sol_line("07", seven_a, seven_b, part_space, 1);

    std::string eight_a = std::to_string(dayEight.getPartOne());
    std::string eight_b = std::to_string(dayEight.getPartTwo());
    print_sol_line("08", eight_a, eight_b, part_space, 1);
    
    std::string nine_a = std::to_string(dayX.getPartOne());
    std::string nine_b = std::to_string(dayX.getPartOne());
    print_sol_line("09", nine_a, nine_b, part_space, 0);
    /*
    int ten_a = dayX.getPartOne();
    int ten_b = dayX.getPartTwo();
    print_sol_line("10", ten_a, ten_b, part_space, 0);
    int eleven_a = dayX.getPartOne();
    int eleven_b = dayX.getPartTwo();
    print_sol_line("11", eleven_a, eleven_b, part_space, 0);
    int twelve_a = dayX.getPartOne();
    int twelve_b = dayX.getPartTwo();
    print_sol_line("12", twelve_a, twelve_b, part_space, 0);
    int thirteen_a = dayX.getPartOne();
    int thirteen_b = dayX.getPartTwo();
    print_sol_line("13", thirteen_a, thirteen_b, part_space, 0);
    int fourteen_a = dayX.getPartOne();
    int fourteen_b = dayX.getPartTwo();
    print_sol_line("14", fourteen_a, fourteen_b, part_space, 0);
    int fifteen_a = dayX.getPartOne();
    int fifteen_b = dayX.getPartTwo();
    print_sol_line("15", fifteen_a, fifteen_b, part_space, 0);
    int sixteen_a = dayX.getPartOne();
    int sixteen_b = dayX.getPartTwo();
    print_sol_line("16", sixteen_a, sixteen_b, part_space, 0);
    int seventeen_a = dayX.getPartOne();
    int seventeen_b = dayX.getPartTwo();
    print_sol_line("17", seventeen_a, seventeen_b, part_space, 0);
    int eightteen_a = dayX.getPartOne();
    int eightteen_b = dayX.getPartTwo();
    print_sol_line("08", eightteen_a, eightteen_b, part_space, 0);
    int nineteen_a = dayX.getPartOne();
    int nineteen_b = dayX.getPartTwo();
    print_sol_line("09", nineteen_a, nineteen_b, part_space, 0);
    int twenty_a = dayX.getPartOne();
    int twenty_b = dayX.getPartTwo();
    print_sol_line("09", twenty_a, twenty_b, part_space, 0);
    int twentyone_a = dayX.getPartOne();
    int twentyone_b = dayX.getPartTwo();
    print_sol_line("01", twentyone_a, twentyone_b, part_space, 0);

    int twentytwo_a = dayX.getPartOne();
    int twentytwo_b = dayX.getPartTwo();
    print_sol_line("02", twentytwo_a, twentytwo_b, part_space, 0);

    int twentythree_a = dayX.getPartOne();
    int twentythree_b = dayX.getPartTwo();
    print_sol_line("03", twentythree_a, twentythree_b, part_space, 0);

    int twentyfour_a = dayX.getPartOne();
    int twentyfour_b = dayX.getPartTwo();
    print_sol_line("04", twentyfour_a, twentyfour_b, part_space, 0);

    int twentyfive_a = dayX.getPartOne();
    int twentyfive_b = dayX.getPartTwo();
    print_sol_line("05", twentyfive_a, twentyfive_b, part_space, 0);
*/
    for (size_t i = 0; i < total; i++) {
        std::cout << "\033[1;35m"
                  << "-"
                  << "\033[0m";
    }
    std::cout << "\n";
    int counter = 1;
    for (auto time : times) {
        std::cout << "Day " << counter << ": " << time.count() << " ms\n";
        counter++;
    }
    return 0;
}

void print_sol_line(std::string day, std::string a, std::string b, int part_space, int color) {
    int len = 0;
    int a_space = part_space - a.length();
    int b_space = part_space - b.length();
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