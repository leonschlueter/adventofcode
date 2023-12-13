

def parse_input(f):
    res = 0
    scores = []
    for line in f:
        score = 0
        split = line.split("|")
        card = list(filter(None, split[0].split(":")[1].split(" ")))
        draw = list(filter(None, split[1].rstrip().split(" ")))
        correct = list(set(card) & set(draw))
        # print("---------")
        # print(len(correct))
        if(len(correct) >= 1):
            score = 1
        for i in range(1, len(correct)):
            score *= 2
            
        res += score
        scores.append(len(correct))
       # print(score)
    return res,scores



def main():
    f = open("input/day04")
    res1,scores = parse_input(f)
    #print(scores)
    tot_copies = [1]*len(scores)

   # print(len(scores))
    for i in range(0, len(scores)):
        score =  scores[i]
        amt = tot_copies[i]
        # print(str(amt)+" times card "+str(i)+" with correct: "+str(score))
        for j in range(1, score+1):
            #print("card "+str(i)+" won to add to "+str(i+j))
            tot_copies[i+j] = tot_copies[i+j]+amt
    #print(tot_copies)
    print(sum(tot_copies))

if __name__ == "__main__":
    main()