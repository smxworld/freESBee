<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://www.progettoicar.it/ipa/types" exclude-result-prefixes="xs">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/datiRisposta">
		<risposta_RichiestaRispostaAsincrona_AggiornamentoIPA>
			<xsl:attribute name="xsi:schemaLocation">
				<xsl:value-of select="'http://www.progettoicar.it/ipa/types ./targetXMLtoXML.xsd'"/>
			</xsl:attribute>
			<correzione>
				<xsl:value-of select="datiCompleti/datiCostanti/Correzione"/>
			</correzione>
		</risposta_RichiestaRispostaAsincrona_AggiornamentoIPA>
	</xsl:template>
</xsl:stylesheet>