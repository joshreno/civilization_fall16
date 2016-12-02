package view;
/**
 * This is an enum class that represents all the
 * Civilizations that the user may chose from
 */
public enum CivEnum {

    ANCIENT_EGYPT {
        @Override
        public String toString() {
            return "Ancient Egypt";
        }
    },
    QIN_DYNASTY {
        @Override
        public String toString() {
            return "Qin Dynasty";
        }
    },
    ROMAN_EMPIRE {
        @Override
        public String toString() {
            return "Roman Empire";
        }
    },
    MESOPOTAMIA {
        @Override
        public String toString() {
            return "Mesopotamia";
        }

    },
    RUSSIAN_EMPIRE {
        @Override
        public String toString() {
            return "Russian Empire";
        }
    },
    BRITISH_EMPIRE {
        @Override
        public String toString() {
            return "British Empire";
        }
    }

}