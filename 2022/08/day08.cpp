#include <fstream>
#include <iostream>
#include <iterator>
#include <map>
#include <sstream>
#include <string>
#include <vector>

#include "day08.hpp"

DayEight::DayEight(std::string filename) {
    this->filename = filename;

    std::vector<std::vector<int>> input = this->parse_input(filename);

    this->part_one = this->calculate_scoreA(input);
    this->part_two = this->calculate_scoreB(input);
}

int DayEight::calculate_scoreA(std::vector<std::vector<int>> input) {
    //std::cout << "calc a\n";
    
    int result = 0;
    int height = input.size();
    int width = input[0].size();
    int isSeen [width][height];

    for (int i = 0; i < height; i++)
        for (int j = 0; j < width; j++)
            isSeen[i][j] = 0;


    for (int i = 0; i < height; i++){
        int curr_max = 0;
         for (int j = 0; j < width - 1; j++){
            if(input[i][j] > curr_max){
              //  std::cout << "From left "<<i<<" "<<j<<'\n';
                isSeen[i][j] = 1;
                 curr_max = input[i][j];
                result++;
            }
        }
    }
    
    for (int i = 0; i < height; i++){
        int curr_max = 0;
         for (int j = width-1 ; j > -1; j--){
            if(input[i][j] > curr_max){
                 //std::cout << "From right "<<i<<" "<<j<<'\n';
                isSeen[i][j] = 1;
                curr_max = input[i][j];
                result++;
            }
        }
    }
    
    for (int i = 0; i < width; i++){
        int curr_max = 0;
         for (int j = height -1 ; j > -1; j--){
            if(input[j][i] > curr_max){
               //  std::cout << "From bottom "<<j<<" "<<i<<'\n';
                isSeen[j][i] = 1;
                 curr_max = input[j][i];
                result++;
            }
        }
    }
    
     for (int i = 0; i < width; i++){
        int curr_max = 0;
         for (int j = 0; j < height; j++){
            if(input[j][i] > curr_max){
                //std::cout << "From top "<<j<<" "<<i<<'\n';
                isSeen[j][i] = 1;
                 curr_max = input[j][i];
                result++;
            }
        }
     }
     
    result = 0;
      for (int i = 0; i < height; i++){
        for (int j = 0; j < width; j++){
            //std::cout << isSeen[i][j];
            if(isSeen[i][j] == 1){

                result++;
            }
        }
        //std::cout<<'\n';
      }
  
        


    return result;
}

/*
    Calculates the score of a vector<int> with height 2, where:
    1 = Stone, 2 = Paper, 3 = Scissors for a & 1 = loss, 2 = draw, 3 = win for b.
    @param match A vector<int> [a, b] of height 2, where a is the form of enemy and b stands for loss/draw/win
    @return Score of match: Form chosen + 0/3/6 depending on loss/draw/win
*/
int DayEight::calculate_scoreB(std::vector<std::vector<int>> input) {
    int result = 0;
    int height = input.size();
    int width = input[0].size();

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
           int a = 0;
           int b = 0;
           int c = 0;
           int d = 0;

            for (int k = j+1; k < width; k++)
            {
                a++;
                if(input[i][j] <= input[i][k]){
                    
                    break;
                }
            }
            for (int k = j-1; k > -1; k--)
            {
                b++;
                if(input[i][j] <= input[i][k]){
                    break;
                }
            }

            for (int k = i+1; k < height; k++)
            {
                c++;
                if(input[i][j] <= input[k][j]){
                    break;
                }
            }

             for (int k = i-1; k > -1; k--)
            {
                d++;
                if(input[i][j] <= input[k][j]){
                    break;
                }
            }
              int score = a*b*c*d;
            //std::cout<< "Position "<<i<<" "<<j<<": " << score <<'\n';
            if(score > result){
                result = score;
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
std::vector<std::vector<int>> DayEight::parse_input(std::string &filename) {
    std::ifstream file(filename);
    std::vector<std::vector<int>> input;
    std::string line;
    while (std::getline(file, line)) {
        std::vector<int> l; 
        for(int i = 0; i< line.length(); i++){
            l.push_back(line[i]);
        }
        input.push_back(l);
    }

    return input;
}

int DayEight::getPartOne() {
    return this->part_one;
}
int DayEight::getPartTwo() {
    return this->part_two;
}