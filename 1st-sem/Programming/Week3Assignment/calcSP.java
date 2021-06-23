public class calcSP{
    {
        float mp = 1000.55f, sp;
        char cat = 'C';
        if(cat=='A'){
            sp=mp-(mp*60/100);
        }
        else if(cat=='B'){
            sp=mp-(mp*40/100);
        }
        else if(cat=='C'){
            sp=mp-(mp*20/100);
        }
        else if(cat=='D'){
            sp=mp-(mp*10/100);
        }
        else{
            sp=mp;
        }
        System.out.println("Selling price is "+sp);
    }
}