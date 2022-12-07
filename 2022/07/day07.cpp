#include <fstream>
#include <iostream>
#include <iterator>
#include <map>
#include <sstream>
#include <string>
#include <vector>

#include "day07.hpp"


DaySeven::DaySeven(std::string filename) {
    this->filename = filename;
    this->l =  std::vector<std::pair<std::string, int>>();
    folder root = this->parse_input(filename);
    this->part_one = 0;
    this->part_two = 0;
    this->calculate_scoreA(&root);
    this->calculate_scoreB(&root);
}



void DaySeven::calculate_scoreA(folder* curr){
   
     for (int i = 0; i < curr->folders.size(); i++) {
        this->calculate_scoreA(&curr->folders[i]);
        curr->file_size += curr->folders[i].file_size;
    }
    
    this->l.push_back(std::pair(curr->name, curr->file_size));
    if (curr->file_size <= 100000) {
        this->part_one += curr->file_size;
    }
}


void DaySeven::calculate_scoreB(folder* curr) {
    int minimum = INT32_MAX;
    int remaining;
    for(std::pair<std::string, int> p : this->l){
        if(p.first == "/"){
            remaining = 70000000 - p.second;
        }
    }

    for(std::pair<std::string, int> p : this->l){
        if((remaining + p.second >= 30000000) && (p.second < minimum)){
            minimum = p.second;
        }
    }
    this->part_two = minimum;
}


folder DaySeven::parse_input(std::string &filename) {
    std::ifstream file(filename);
    
    folder* curr = new folder();
    curr->folders= std::vector<folder>();
    curr->name = "/";
    curr->file_size = 0;

    folder* root = curr;

    std::string line;

    while (std::getline(file, line)) {
        
        start:
        if(line[0] == '$'){
            if(!line.compare("$ cd ..")){
                curr = curr->previous;
            } else if(!line.compare("$ cd /")){
                curr = root;
            } else if(line[2] == 'c'){
                std::string name = line.substr(5, line.size()-5);
                for (int i = 0; i < curr->folders.size(); i++)
                {
                    if(!name.compare(curr->folders[i].name)){
                        curr = &curr->folders[i];
                        goto finished;
                    }
                }
                folder* new_folder = new folder();
                new_folder->previous = curr;
                new_folder->folders = std::vector<folder>();
                new_folder->name = name;
                new_folder->file_size = 0;
                curr->folders.push_back(*new_folder);
                curr = new_folder;
               // std::cout << "Added "<<name<<'\n';
            } else{
                while(getline(file, line)){
                     
                    if(line[0] == '$'){
                        goto start;
                    } else if(line[0] == 'd'){
                        std::string name = line.substr(4, line.size()-4);
                        folder* f = new folder();
                        f->previous = curr;
                        f->file_size = 0;
                        f->folders = std::vector<folder>();
                        f->name = name;
                        curr->folders.push_back(*f);
                       //  std::cout << "Added "<<name<<'\n';
                    } else{
                        char crap[100];
                        int val;
                        sscanf(line.c_str(), "%d %s", &val, &crap);
                        curr->file_size += val;
                    }
                }
            }
        }

    finished:
       
        int i;
    }

    return *root;
}

int DaySeven::getPartOne() {
    return this->part_one;
}
int DaySeven::getPartTwo() {
    return this->part_two;
}

