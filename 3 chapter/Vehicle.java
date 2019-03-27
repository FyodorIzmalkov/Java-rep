class Vehicle{
    int passengers;
    int fuelcap;
    int mpg;

    int range(){
        return (fuelcap * mpg);
    }
    double fuelneeded(int miles)
    {
        return ((double) miles / mpg);
    }
}