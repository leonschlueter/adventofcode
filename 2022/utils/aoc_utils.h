#ifndef AOC_INPUT
#define AOC_INPUT

#include <fstream>
#include <vector>
#include <sstream>
#include <iostream>

/*
    Returns a vector of integers from given input file, assuming the file contains only integers.
    @param filename - The name of the file.
    @return vector of integers with input from original file
*/
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

/*
    Returns a 2D vector of integers from given input file, assuming the file contains only integers.
    @param filename - The name of the file.
    @return 2D vector of integers with input from original file
*/
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

/*
    Returns each line as a string in a vector with the given input file.
    @param filename - The name of the file.
    @return vector of strings with lines from original file
*/
std::vector<std::string> get_string(std::string filename){
    std::string line;
    std::ifstream file(filename);
    std::vector<std::string> vec;
    while(std::getline(file, line)){
        vec.push_back(line);
    }
    return vec; 
}

/*
    Prints integers from vector into console. 
    @param vec - pointer to a vector of integers
    @return void 
*/
void print_vector(std::vector<int> &vec){
    for(int i : vec){
        std::cout << i << ' ';
    }
    std::cout << '\n';
    return;
}

/*
    Prints integers from 2D vector into console. 
    @param vec - pointer to a 2D vector of integers
    @return void 
*/
void print_multivector(std::vector<std::vector<int>> &vec){
    for(std::vector<int> v : vec){
       print_vector(v);
    }
   
    return;
}
#endif