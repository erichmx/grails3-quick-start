import org.apache.lucene.analysis.standard.StandardTokenizerFactory
import org.apache.lucene.analysis.core.LowerCaseFilterFactory
import org.apache.lucene.analysis.ngram.NGramFilterFactory


grails.plugins.hibernatesearch = {
  rebuildIndexOnStart false
  throwOnEmptyQuery false
//	fullTextFilter name: "reserveContext", impl: ReserveContextFullTextFilterFactory, cache: 'none'

  analyzer( name: 'ngram', tokenizer: StandardTokenizerFactory ) {
    filter LowerCaseFilterFactory
    filter(NGramFilterFactory) {
      param 'minGramSize', 3
      param 'maxGramSize', 3
    }
  }

}
