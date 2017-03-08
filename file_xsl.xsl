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
			</tr>
			<xsl:for-each select="//actor">
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
				</tr>
			</xsl:for-each>
			<tr>
				<td align="center" colspan="3" style="color:#7D9DDB">Ranking</td>
			</tr>
			<xsl:for-each select="//stats">
				<xsl:for-each select="podium_actors">
					<tr>
						<td align="center">
							<b>
								<xsl:if test="position() = 1">
									First
								</xsl:if>
								<xsl:if test="position() = 2">
									Second
								</xsl:if>
								<xsl:if test="position() = last()">
									Third
								</xsl:if>
							</b>
						</td>
						<td align="center" colspan="2">
							<xsl:value-of select="." />
						</td>
					</tr>
				</xsl:for-each>
				<tr>
					<td align="center" colspan="3" style="color:#7D9DDB">Number of actors</td>
				</tr>
				<tr>
					<td align="center" colspan="3">
						<xsl:value-of select="no_actors" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>