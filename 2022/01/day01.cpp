#include <fstream>     
#include <iostream>
int main(int argc, char const *argv[])
{
    if(argc != 2){
        std::cout << "NOT ENOUGH ARGS \n";
    }
    std::cout << argv[1] << "\n";
    return 0;
}