package model;

import utils.StringUtils;

import java.time.YearMonth;

public class Experienced extends Candidate{
    private int expInYear;
    private String proSkill;

    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setExpInYear(int expInYear) throws Exception {
        int maxExpInYear = YearMonth.now().getYear() - super.getYob();
        if(expInYear < 0 || expInYear > 100){
            throw new Exception("Input must between 0 and 100");
        }
        if(expInYear > maxExpInYear){
            throw new Exception("Input must smaller than maxExpInYear");
        }
        this.expInYear = expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
