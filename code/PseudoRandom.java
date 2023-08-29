class PseudoRandom {
    
    long MULTIPLIER = 1103515245;
    long INCREMENT = 12345;
    long MODULUS = (long) Math.pow(2, 31);

    private long seed;

    PseudoRandom(long seed) //constructor initialize the seed variable.
    {
        this.seed = seed; //seed random number
    }

    int nextInt() 
    {
        seed = (MULTIPLIER * seed + INCREMENT) % MODULUS;
        return (int) seed;
    }


    int generateRandomNumber(int min, int max) { //random number range
        int range = max - min + 1;
        int randomNumber = min + nextInt() % range;
        if(randomNumber<0)randomNumber=randomNumber*-1; //turn the negetive number to positive number using *-1
        return randomNumber;
    }
}
