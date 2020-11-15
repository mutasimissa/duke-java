public class Part2 {
        public String findSimpleGene (String dna, String startCodon, String stopCodon) {
        
        if (Character.isUpperCase(dna.charAt(0))) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        int geneStart = dna.indexOf(startCodon);
        if ( geneStart == -1 ) {
            return "No " + startCodon + " was found!";
        }

        int geneEnd = dna.indexOf(stopCodon, geneStart + 3);
        if ( geneEnd == -1 ) {
            return "No " + stopCodon + " Was found!";
        }
        
        if ( (geneEnd - (geneStart + 3 )) % 3 != 0) {
            return "Bad Gene Formula!";
        }
              
        return "Found Gene: " + dna.substring(geneStart, geneEnd + 3);
    }
    
    public void testSimpleGene () {
        String DNA[] =
        {
            "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA",
            "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT",
            "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT",
            "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT",
            "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA",
            "AAAATTTAGCCATAAACGAAAGTTTGACTAAGCTACGCTAACACAGGGTT",
            "GGTAAATTTCGTGCCAGCCACCGCGGCCATACGATTAACCCAAATTAATA",
            "AGCATCGGCGTAGAGCGTGTTTAGGAGTCGACACACAAATAAAGTTAAAT",
            "TAAATCTAAGCCGTAAAAAGCTAAGGATTAGACAAAAATAACCCACGAAA",
            "GTGACTTTACCAGCTCTGAATACACGATAGCTAGGACACAAACTGGGATT",
            "AGATACCCCACTATGCCTAGCCCTAAACCTCAATGGCTGCTAACAAAGCC",
            "ATTCGCCAGAGAACTACTAGCAAAGGCTTAAAACTCAAAGGACTTGGCGG",
            "TGCTTTACATCCCCCTAGAGGAGCCTGTCCCATAATCGATAAACCCCGAT",
            "AAACCTCACCACCACTAGCTAATTCAGCCTATATACCGCCATCTTCAGCC",
            "ATGCCCAAATTTTAA",
            "atgcccaaattttaa"
        };
        for (String dna : DNA) {
            System.out.println("DNA Code: " + dna);
            System.out.println(findSimpleGene(dna, "ATG", "TAA"));
            System.out.println("");
        }
    }
    
    public static void main (String[] args) {
        Part2 P2 = new Part2();
        P2.testSimpleGene();
    }
}
