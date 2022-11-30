#ifndef AOC_INPUT
#define AOC_INPUT

#include <fstream>
#include <vector>
#include <sstream>
#include <iostream>

//Reads input from file and puts every single int into vector
std::vector<int> get_singleint_input(std::string filename){

    std::ifstream file(filename);
    int x;
    std::vector<int> vec;

    while(file >> x){
        vec.push_back(x);
    }
    std::cout << "Data parsing into single vector done."<<'\n';
    return vec;
}

//reads input from file and puts it into 2d array
std::vector<std::vector<int>> get_int_input(std::string filename){
    std::string line;
    std::ifstream file(filename);
    std::vector<std::vector<int>> matrix;

    while(std::getline(file, line, '\n')){
        std::stringstream ss(line);
        std::vector<int> row; 
        int x; 
        while(ss >> x){
            row.push_back(x);
        }
        matrix.push_back(row);
    }
    std::cout << "Data parsing into multivector done."<<'\n';
    return matrix;
}

std::vector<std::string> get_string(std::string filename){
    std::string line;
    std::ifstream file(filename);
    std::vector<std::string> vec;
    while(std::getline(file, line)){
        vec.push_back(line);
    }
    return vec; 
}


void print_vector(std::vector<int> vec){
    for(int i : vec){
        std::cout << i << ' ';
    }
    std::cout << '\n';
    return;
}

void print_multivector(std::vector<std::vector<int>> vec){
    for(std::vector<int> v : vec){
       print_vector(v);
    }
   
    return;
}
#endif