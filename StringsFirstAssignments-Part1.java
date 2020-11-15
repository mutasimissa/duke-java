public class Part1 {
    
    public String findSimpleGene (String dna) {
        int geneStart = dna.indexOf("ATG");
        if ( geneStart == -1 ) {
            return "No ATG was found!";
        }

        int geneEnd = dna.indexOf("TAA", geneStart + 3);
        if ( geneEnd == -1 ) {
            return "No TAA Was found!";
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
            "ATGCCCAAATTTTAA"
        };
        for (String dna : DNA) {
            System.out.println("DNA Code: " + dna);
            System.out.println(findSimpleGene(dna));
            System.out.println("");
        }
    }
    
    public static void main (String[] args) {
        Part1 P1 = new Part1();
        P1.testSimpleGene();
    }
}
