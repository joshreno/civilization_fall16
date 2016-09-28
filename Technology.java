public class Technology {
    private int understanding = 0;
    private boolean foundMeaningOfLife = false;

    private int experienceLevel = 0;
    private boolean builtWonderOfTheWorld = false;

    public void philosophize() {
        understanding = understanding + 25;
        foundMeaning();
    }

    public void improveWriting() {
        understanding = understanding + 10;
        foundMeaning();
    }

    public void foundMeaning() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void increaseExperience(int newExperience) {
        experienceLevel = experienceLevel + newExperience;
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public boolean hasTechnologyWin() {
        return (builtWonderOfTheWorld && foundMeaningOfLife);
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }

}