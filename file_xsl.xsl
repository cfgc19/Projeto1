<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<title> Actors </title>
	</head>
	<body style="font-family:Courier">
		<h1> List of Actors</h1>
		<table border="1">
			<tr>
				<th style="color:#7D9DDB"> Names
				</th>
				<th style="color:#7D9DDB"> Serie's List
				</th>
				<th style="color:#7D9DDB">Number of Episodes
				</th>
				<th colspan="2" style="color:#7D9DDB">Ranking </th>
			</tr>

			<xsl:for-each select="//actor | //stats">
				<tr>
					<td>
						<xsl:value-of select="actor_name" />
					</td>

					<td>
						<xsl:for-each select="serie">
							<xsl:value-of select="." />
							<xsl:if test="position() != last()">
								,
							</xsl:if>
						</xsl:for-each>
					</td>
					<td>
						<xsl:value-of select="no_episodes" />
					</td>
					<td>
						<xsl:value-of select="no_actors" />
					</td>
					<td>
						<xsl:for-each select="podium_actors">
							<xsl:value-of select="." />
							<xsl:if test="position() != last()">
								,
							</xsl:if>
						</xsl:for-each>
					</td>
				</tr>
				</xsl:for-each>
		</table>
	</body>
</html>